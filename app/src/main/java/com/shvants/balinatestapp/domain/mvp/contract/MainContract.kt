package com.shvants.balinatestapp.domain.mvp.contract

import com.shvants.balinatestapp.data.repository.Image
import com.shvants.balinatestapp.domain.mvp.presenter.BasePresenter
import com.shvants.network.data.entity.ImageDtoIn
import java.util.*

interface MainContract {

    interface View {
        fun setImages(list: List<Image>)
    }

    interface Presenter : BasePresenter<View> {
        val hasMore: Boolean

        fun loadImages(page: Int, locale: Locale)
        fun saveImage(image: ImageDtoIn)
    }
}