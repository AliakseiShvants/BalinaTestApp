package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.domain.mvp.contract.MainContract

class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadImage(page: Int) {

    }
}