package com.shvants.balinatestapp.util

import android.graphics.Bitmap
import android.util.Base64.DEFAULT
import android.util.Base64.encodeToString
import com.shvants.balinatestapp.data.repository.Image
import com.shvants.database.data.model.ImageModel
import com.shvants.network.data.entity.ImageDtoOut
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

fun Bitmap.convertToString(): String {
    val baos = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.PNG, 100, baos)

    return encodeToString(baos.toByteArray(), DEFAULT)
}

fun ImageDtoOut.toDbModel() = ImageModel(
    id = id,
    url = url,
    date = date.toLong(),
    lat = lat,
    lng = lng
)

fun ImageModel.toUiModel(locale: Locale) = Image(
    id = id,
    url = url,
    date = date.convertToDate(locale)
)

private fun Long.convertToDate(locale: Locale) =
    SimpleDateFormat("dd.MM.yyyy", locale).format(Date(this))