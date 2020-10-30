package com.shvants.network.koin

import com.shvants.network.NetworkService
import com.shvants.network.TokenHelper
import com.shvants.network.api.ITokenHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val networkModule = module {
    single<ITokenHelper> { TokenHelper(androidApplication()) }
    single {
        NetworkService().accountApi
    }
}