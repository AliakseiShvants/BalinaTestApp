package com.shvants.balinatestapp.util

import android.graphics.Bitmap
import android.util.Base64.DEFAULT
import android.util.Base64.encodeToString
import java.io.ByteArrayOutputStream

fun Bitmap.convertToString(): String {
    val baos = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.PNG, 100, baos)

    return encodeToString(baos.toByteArray(), DEFAULT)
}