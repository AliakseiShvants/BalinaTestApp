package com.shvants.balinatestapp.koin

import com.shvants.balinatestapp.data.repository.AccountRepository
import com.shvants.balinatestapp.data.repository.ImageRepository
import com.shvants.balinatestapp.domain.mvp.contract.LoginContract
import com.shvants.balinatestapp.domain.mvp.contract.MainContract
import com.shvants.balinatestapp.domain.mvp.contract.PhotosContract
import com.shvants.balinatestapp.domain.mvp.contract.RegisterContract
import com.shvants.balinatestapp.domain.mvp.presenter.LoginPresenter
import com.shvants.balinatestapp.domain.mvp.presenter.MainPresenter
import com.shvants.balinatestapp.domain.mvp.presenter.PhotosPresenter
import com.shvants.balinatestapp.domain.mvp.presenter.RegisterPresenter
import org.koin.dsl.module

val appModule = module {

    single { AccountRepository() }
    single { ImageRepository() }

    factory<LoginContract.Presenter> { LoginPresenter(accountRepository = get()) }
    factory<RegisterContract.Presenter> { RegisterPresenter(accountRepository = get()) }
    factory<MainContract.Presenter> { MainPresenter() }
    factory<PhotosContract.Presenter> { PhotosPresenter(imageRepository = get()) }
}