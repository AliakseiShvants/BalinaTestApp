package com.shvants.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseData(
    @Expose
    @SerializedName("data")
    val user: SignUserOutDto
)

