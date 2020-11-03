package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.domain.mvp.contract.BaseContract

interface BasePresenter<V> : BaseContract.Presenter {

    fun attachView(view: V)

    fun detachView()
}