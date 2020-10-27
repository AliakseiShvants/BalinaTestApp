package com.shvants.balinatestapp.koin

import com.shvants.balinatestapp.contract.RegisterContract
import com.shvants.balinatestapp.presenter.RegisterPresenter
import com.shvants.balinatestapp.repository.AccountRepository
import com.shvants.balinatestapp.view.fragment.RegisterFragment
import org.koin.dsl.module

val appModule = module {
    single {
        AccountRepository(get(), get())
    }

    scope<RegisterFragment> {
        scoped<RegisterContract.Presenter> { RegisterPresenter(get()) }
    }
}