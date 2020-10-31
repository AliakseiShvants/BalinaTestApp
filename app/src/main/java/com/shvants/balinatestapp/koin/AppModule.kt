package com.shvants.balinatestapp.koin

import com.shvants.balinatestapp.presenter.LoginPresenter
import com.shvants.balinatestapp.repository.AccountRepository
import com.shvants.balinatestapp.view.fragment.LoginFragment
import org.koin.dsl.module

val appModule = module {
    single {
        AccountRepository(
            accountApi = get(),
            tokenHelper = get()
        )
    }
    scope<LoginFragment> {
        scoped { LoginPresenter() }
    }
}