package com.shvants.database.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageModel(
    @PrimaryKey
    val id: Int,
    val url: String,
    val date: Long,
    val lat: Double,
    val lng: Double
)