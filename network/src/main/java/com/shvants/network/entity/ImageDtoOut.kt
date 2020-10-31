package com.shvants.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageDtoOut(
    @Expose
    @SerializedName("id")
    private val id: Int,

    @Expose
    @SerializedName("url")
    private val url: String,

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