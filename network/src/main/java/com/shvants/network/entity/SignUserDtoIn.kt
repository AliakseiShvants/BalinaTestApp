package com.shvants.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUserDtoIn(
    @Expose
    @SerializedName("login")
    val login: String,

    @Expose
    @SerializedName("password")
    val password: String
)