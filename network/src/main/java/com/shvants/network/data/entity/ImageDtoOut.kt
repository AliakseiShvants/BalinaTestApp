package com.shvants.network.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageDtoOut(
    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("url")
    val url: String,

    @Expose
    @SerializedName("date")
    val date: Long,

    @Expose
    @SerializedName("lat")
    val lat: Double,

    @Expose
    @SerializedName("lng")
    val lng: Double
)