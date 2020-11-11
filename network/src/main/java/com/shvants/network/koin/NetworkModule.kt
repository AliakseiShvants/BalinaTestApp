package com.shvants.network.koin

import com.shvants.network.domain.ITokenHelper
import com.shvants.network.domain.NetworkService
import com.shvants.network.domain.TokenHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val networkModule = module {
    single<ITokenHelper> { TokenHelper(androidApplication()) }
    single {
        NetworkService(tokenHelper = get()).accountService
    }
    single {
        NetworkService(tokenHelper = get()).commentService
    }
    single {
        NetworkService(tokenHelper = get()).imageService
    }
}