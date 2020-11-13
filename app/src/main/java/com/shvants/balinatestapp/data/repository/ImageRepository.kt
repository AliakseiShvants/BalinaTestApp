package com.shvants.balinatestapp.data.repository

import com.shvants.balinatestapp.util.toDbModel
import com.shvants.balinatestapp.util.toUiModel
import com.shvants.database.domain.ImageDAO
import com.shvants.network.data.entity.ImageDtoIn
import com.shvants.network.data.entity.ImageDtoOut
import com.shvants.network.domain.ImageService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

class ImageRepository : KoinComponent {

    private val dao: ImageDAO by inject()
    private val service: ImageService by inject()

    private var networkCache = mutableListOf<ImageDtoOut>()

//    suspend fun load(page: Int, locale: Locale): List<Image> {
//        return withContext(Dispatchers.IO) {
//            if (page == 1) {
//                networkCache.clear()
//                dao.deleteAll()
//            }
//
//            val networkList: List<ImageDtoOut> = service.getImages(page).data
//            networkCache.addAll(networkList)
//
//            dao.insertAll(networkList.map { it.toDbModel() })
//            dao.getImages().map { it.toUiModel(locale) }
//        }
//    }


    suspend fun saveImage(image: ImageDtoIn) {
        withContext(Dispatchers.IO) {
            val imageNetwork = service.saveImage(image).data
            dao.save(imageNetwork.toDbModel())
        }
    }

    suspend fun loadFromDb(page: Int, locale: Locale): List<Image> {
        return withContext(Dispatchers.IO) {
            var dbList = dao.getImages(page)

            if (dbList.isEmpty()) {
                val networkList = loadFromNetwork(page)
                dao.insertAll(networkList.map { it.toDbModel() })
                dbList = dao.getImages(page)
            }

            dbList.map { it.toUiModel(locale) }
        }
    }

    suspend fun loadFromNetwork(page: Int): List<ImageDtoOut> {
        return withContext(Dispatchers.IO) {
            service.getImages(page).data

        }
    }
}