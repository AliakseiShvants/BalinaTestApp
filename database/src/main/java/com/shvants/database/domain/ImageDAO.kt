package com.shvants.database.domain

import androidx.room.Dao
import androidx.room.Insert
import com.shvants.database.data.model.ImageModel

@Dao
interface ImageDAO {

    @Insert
    fun save(image: ImageModel)
}