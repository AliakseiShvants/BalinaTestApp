package com.shvants.balinatestapp.koin

import com.shvants.balinatestapp.repository.AccountRepository
import org.koin.dsl.module

val appModule = module {
    single {
        AccountRepository(
            accountApi = get(),
            tokenHelper = get()
        )
    }

//    single { RegisterPresenter() }
//    single { LoginPresenter() }

//    scope<RegisterFragment> {
//        factory { RegisterPresenter() }
//    }
}