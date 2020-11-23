package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.data.repository.ImageRepository
import com.shvants.balinatestapp.domain.mvp.contract.PhotosContract
import com.shvants.network.data.entity.ImageDtoIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

class PhotosPresenter(
    private val imageRepository: ImageRepository
) : PhotosContract.Presenter, CoroutineScope {

    private var view: PhotosContract.View? = null

    override val hasMore: Boolean
        get() = imageRepository.hasMore

    override fun attachView(view: PhotosContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadImages(page: Int, locale: Locale) {
        launch {
            val result = imageRepository.loadFromDb(page, locale)
            view?.setImages(result)
        }
    }

    override fun saveImage(image: ImageDtoIn, page: Int, locale: Locale) {
        launch {
            val response = imageRepository.saveImage(image, locale)
            view?.addImage(response)
        }
    }
}