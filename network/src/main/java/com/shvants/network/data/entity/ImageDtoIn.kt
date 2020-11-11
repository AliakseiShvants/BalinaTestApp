package com.shvants.network.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageDtoIn(
    @Expose
    @SerializedName("base64Image")
    private val image: String,

    @Expose
    @SerializedName("date")
    private val date: Long,

    @Expose
    @SerializedName("lat")
    private val lat: Double,

    @Expose
    @SerializedName("lng")
    private val lng: Double
)