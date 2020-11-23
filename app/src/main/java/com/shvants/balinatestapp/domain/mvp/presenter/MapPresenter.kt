package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.data.repository.ImageRepository
import com.shvants.balinatestapp.domain.mvp.contract.MapContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

class MapPresenter(
    private val imageRepository: ImageRepository
) : MapContract.Presenter, CoroutineScope {

    private var view: MapContract.View? = null

    override fun attachView(view: MapContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadAllImagesFromDb(locale: Locale) {
        launch {
            val result = imageRepository.loadAllFromDb(locale)
            view?.getAllImagesFromDb(result)
        }
    }
}