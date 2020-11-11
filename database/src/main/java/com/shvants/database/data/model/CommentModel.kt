package com.shvants.database.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class CommentModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    val date: Long
)
