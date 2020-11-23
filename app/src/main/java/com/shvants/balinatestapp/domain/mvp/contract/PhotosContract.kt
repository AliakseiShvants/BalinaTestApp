package com.shvants.balinatestapp.domain.mvp.contract

import com.shvants.balinatestapp.data.repository.PhotoImage
import com.shvants.balinatestapp.domain.mvp.presenter.BasePresenter
import com.shvants.network.data.entity.ImageDtoIn
import java.util.*

interface PhotosContract {

    interface View {
        fun setImages(list: List<PhotoImage>)
        fun addImage(image: PhotoImage)
    }

    interface Presenter : BasePresenter<View> {
        val hasMore: Boolean

        fun loadImages(page: Int, locale: Locale)
        fun saveImage(image: ImageDtoIn, page: Int, locale: Locale)
    }
}