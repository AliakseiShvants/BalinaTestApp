package com.shvants.balinatestapp.koin

import com.shvants.balinatestapp.data.repository.AccountRepository
import com.shvants.balinatestapp.domain.mvp.contract.LoginContract
import com.shvants.balinatestapp.domain.mvp.contract.RegisterContract
import com.shvants.balinatestapp.domain.mvp.presenter.LoginPresenter
import com.shvants.balinatestapp.domain.mvp.presenter.RegisterPresenter
import com.shvants.balinatestapp.domain.repository.IAccountRepository
import com.shvants.balinatestapp.domain.usecase.AccountUseCase
import com.shvants.balinatestapp.domain.usecase.IAccountUseCase
import org.koin.dsl.module

val appModule = module {

    single<IAccountRepository> { AccountRepository() }
    single<IAccountUseCase> {
        AccountUseCase(
            accountRepository = get(),
        )
    }

    factory<LoginContract.Presenter> {
        LoginPresenter(accountUseCase = get())
    }

    factory<RegisterContract.Presenter> {
        RegisterPresenter(accountUseCase = get())
    }
}