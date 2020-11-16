package com.shvants.balinatestapp.koin

import com.shvants.database.koin.databaseModule
import com.shvants.network.koin.networkModule

val koinModules = listOf(
    appModule,
    networkModule,
    databaseModule
)