package com.shvants.balinatestapp.domain.mvp.contract

import com.shvants.balinatestapp.domain.mvp.presenter.BasePresenter
import com.shvants.network.data.entity.ImageDtoIn

interface MainContract {

    interface View {

    }

    interface Presenter : BasePresenter<View> {
        fun loadImage(page: Int)
        fun saveImage(image: ImageDtoIn)

    }
}