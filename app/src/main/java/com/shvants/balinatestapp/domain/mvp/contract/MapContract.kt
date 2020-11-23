package com.shvants.balinatestapp.domain.mvp.contract

import com.shvants.balinatestapp.data.repository.MapImage
import com.shvants.balinatestapp.domain.mvp.presenter.BasePresenter
import java.util.*

interface MapContract {

    interface View {
        fun getAllImagesFromDb(list: List<MapImage>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadAllImagesFromDb(locale: Locale)
    }
}