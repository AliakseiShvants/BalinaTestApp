package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.domain.mvp.contract.BaseContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

interface BasePresenter<V> : BaseContract.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    fun attachView(view: V)

    fun detachView()
}