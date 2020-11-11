package com.shvants.network.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommentDtoIn(
    @Expose
    @SerializedName("text")
    private val text: String
)