package com.shvants.balinatestapp.koin

import com.shvants.balinatestapp.contract.RegisterContract
import com.shvants.balinatestapp.presenter.RegisterPresenter
import com.shvants.balinatestapp.repository.AccountRepository
import org.koin.dsl.module

val appModule = module {
    single {
        AccountRepository(
            accountApi = get(),
            tokenHelper = get()
        )
    }

    single<RegisterContract.Presenter> { RegisterPresenter() }

//    scope<RegisterFragment> {
//        factory { RegisterPresenter() }
//    }
}