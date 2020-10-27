package com.shvants.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUserOutDto(
    @Expose
    @SerializedName("login")
    val login: String,

    @Expose
    @SerializedName("password")
    val password: String,

    @Expose
    @SerializedName("token")
    val token: String
)