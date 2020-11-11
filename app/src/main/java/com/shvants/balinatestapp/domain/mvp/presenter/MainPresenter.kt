package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.data.repository.ImageRepository
import com.shvants.balinatestapp.domain.mvp.contract.MainContract
import com.shvants.network.data.entity.ImageDtoIn

class MainPresenter(
    private val imageRepository: ImageRepository
) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadImage(page: Int) {

    }

    override fun saveImage(image: ImageDtoIn) {

//        imageRepository.saveImage(image)
    }
}