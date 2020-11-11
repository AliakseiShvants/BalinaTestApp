package com.shvants.network.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseDto<T>(
    @Expose
    @SerializedName("status")
    val status: String,

    @Expose
    @SerializedName("data")
    val data: T
)