package com.shvants.balinatestapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64.*
import com.shvants.balinatestapp.data.repository.MapImage
import com.shvants.balinatestapp.data.repository.PhotoImage
import com.shvants.database.data.model.ImageModel
import com.shvants.network.data.entity.ImageDtoIn
import com.shvants.network.data.entity.ImageDtoOut
import okio.ByteString.Companion.decodeBase64
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

fun Bitmap.bitmapToString(): String {
    val baos = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.PNG, 100, baos)

    return encodeToString(baos.toByteArray(), DEFAULT)
}

fun String.stringToBitmap(): Bitmap? {
    val bytes = decode(this, DEFAULT)

    return try {
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    } catch (exception: Exception) {
        null
    }
}

fun ImageDtoIn.toDbModel() = ImageModel(
    id = Random().nextInt(),
    url = base64Image,
    date = date.toLong(),
    lat = lat,
    lng = lng
)

//fun ImageDtoOut.toDbModel() = ImageModel(
//    id = id,
//    url = url,
//    date = date.toLong(),
//    lat = lat,
//    lng = lng
//)

fun ImageModel.toPhotoModel(locale: Locale) = PhotoImage(
    id = id,
    url = url,
    date = date.convertToDate(locale)
)

fun ImageModel.toMapModel(locale: Locale) = MapImage(
    title = date.convertToDate(locale),
    lat = lat,
    lng = lng
)

private fun Long.convertToDate(locale: Locale) =
    SimpleDateFormat("dd.MM.yyyy hh:mm", locale).format(Date(this * 1000))