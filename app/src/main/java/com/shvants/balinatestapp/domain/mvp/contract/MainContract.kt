package com.shvants.balinatestapp.domain.mvp.contract

import com.shvants.balinatestapp.domain.mvp.presenter.BasePresenter

interface MainContract {

    interface View {

    }

    interface Presenter : BasePresenter<View> {
        fun loadImage(page: Int)

    }
}