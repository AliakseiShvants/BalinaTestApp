package com.shvants.balinatestapp.contract

import com.shvants.balinatestapp.presenter.BasePresenter

interface MainContract {

    interface View {

    }

    interface Presenter : BasePresenter<View> {
        fun loadImage(page: Int)

    }
}