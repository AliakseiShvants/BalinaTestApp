package com.shvants.balinatestapp.presenter

import com.shvants.balinatestapp.contract.BaseContract

interface BasePresenter<V> : BaseContract.Presenter {

    fun attachView(view: V)

    fun detachView()
}