package com.shvants.database.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shvants.database.data.model.ImageModel

@Dao
interface ImageDAO {

    @Insert
    fun save(image: ImageModel)

    @Query("SELECT * FROM images ORDER BY date LIMIT 10 * :page")
    fun getImages(page: Int): List<ImageModel>

    @Query("SELECT * FROM images")
    fun getAllImages(): List<ImageModel>

    @Query("DELETE FROM images")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<ImageModel>)
}