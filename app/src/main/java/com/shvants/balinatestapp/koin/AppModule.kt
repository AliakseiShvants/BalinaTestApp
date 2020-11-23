package com.shvants.balinatestapp.koin

import com.shvants.balinatestapp.data.repository.AccountRepository
import com.shvants.balinatestapp.data.repository.ImageRepository
import com.shvants.balinatestapp.domain.mvp.contract.*
import com.shvants.balinatestapp.domain.mvp.presenter.*
import org.koin.dsl.module

val appModule = module {

    single { AccountRepository() }
    single { ImageRepository() }

    factory<LoginContract.Presenter> { LoginPresenter(accountRepository = get()) }
    factory<RegisterContract.Presenter> { RegisterPresenter(accountRepository = get()) }
    factory<MainContract.Presenter> { MainPresenter() }
    factory<PhotosContract.Presenter> { PhotosPresenter(imageRepository = get()) }
    factory<MapContract.Presenter> { MapPresenter(imageRepository = get()) }
}