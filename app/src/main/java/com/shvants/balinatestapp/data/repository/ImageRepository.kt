package com.shvants.balinatestapp.data.repository

import com.shvants.balinatestapp.util.toDbModel
import com.shvants.balinatestapp.util.toMapModel
import com.shvants.balinatestapp.util.toPhotoModel
import com.shvants.database.domain.ImageDAO
import com.shvants.network.data.entity.ImageDtoIn
import com.shvants.network.domain.ImageService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

class ImageRepository : KoinComponent {

    private val dao: ImageDAO by inject()
    private val service: ImageService by inject()

    var hasMore = true

    suspend fun saveImage(image: ImageDtoIn, locale: Locale): PhotoImage {
        return withContext(Dispatchers.IO) {
            val imageNetwork = service.saveImage(image).data
            val dbModel = imageNetwork.toDbModel()
            dao.save(dbModel)

            dbModel.toPhotoModel(locale)
        }
    }

    suspend fun loadFromDb(page: Int, locale: Locale): List<PhotoImage> {
        return withContext(Dispatchers.IO) {
            var dbList = dao.getImages(page)

            if (dbList.isEmpty()) {
                val networkList = service.getImages(page).data
                dao.insertAll(networkList.map { it.toDbModel() })
                dbList = dao.getImages(page)
            }

            if (dbList.size < page * 10) hasMore = false

            dbList.map { it.toPhotoModel(locale) }
        }
    }

    suspend fun loadAllFromDb(locale: Locale): List<MapImage> {
        return withContext(Dispatchers.IO) {
            val dbList = dao.getAllImages()

            dbList.map { it.toMapModel(locale) }
        }
    }
}