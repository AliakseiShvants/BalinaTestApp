package com.shvants.network.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommentDtoOut(
    @Expose
    @SerializedName("id")
    private val id: Int,

    @Expose
    @SerializedName("text")
    private val text: String,

    @Expose
    @SerializedName("date")
    private val date: Long
)