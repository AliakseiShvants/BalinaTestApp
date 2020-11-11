package com.shvants.balinatestapp.data.repository

import com.shvants.database.domain.ImageDAO
import com.shvants.network.data.entity.ImageDtoOut
import com.shvants.network.domain.ImageService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class ImageRepository : KoinComponent {

    private val dao: ImageDAO by inject()
    private val service: ImageService by inject()

    suspend fun saveImage(image: ImageDtoOut) {
        withContext(Dispatchers.IO) {

        }
    }
}