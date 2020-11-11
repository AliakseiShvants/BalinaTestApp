package com.shvants.network.data.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignUserOutDto(
    @Expose
    @SerializedName("userId")
    val userId: Int,

    @Expose
    @SerializedName("login")
    val login: String,

    @Expose
    @SerializedName("token")
    val token: String
) : Parcelable