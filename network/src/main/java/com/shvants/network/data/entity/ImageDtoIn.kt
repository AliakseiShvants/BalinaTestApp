package com.shvants.network.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageDtoIn(
    @Expose
    @SerializedName("base64Image")
    val base64Image: String,

    @Expose
    @SerializedName("date")
    val date: Int,

    @Expose
    @SerializedName("lat")
    val lat: Double,

    @Expose
    @SerializedName("lng")
    val lng: Double
)