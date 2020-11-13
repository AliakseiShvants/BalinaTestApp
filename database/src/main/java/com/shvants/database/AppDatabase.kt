package com.shvants.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shvants.database.data.model.CommentModel
import com.shvants.database.data.model.ImageModel
import com.shvants.database.data.model.UserModel
import com.shvants.database.domain.CommentDAO
import com.shvants.database.domain.ImageDAO
import com.shvants.database.domain.UserDAO

@Database(
    entities = [CommentModel::class, ImageModel::class, UserModel::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDAO
    abstract fun imageDao(): ImageDAO
    abstract fun userDao(): UserDAO
}