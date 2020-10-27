package com.shvants.network.koin

import com.shvants.network.NetworkService
import com.shvants.network.TokenHelper
import com.shvants.network.api.ITokenHelper
import org.koin.dsl.module

val networkModule = module {
    single<ITokenHelper> { TokenHelper() }
    single {
        NetworkService().accountApi
    }
}