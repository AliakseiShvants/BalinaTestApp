package com.shvants.network

import com.shvants.network.api.AccountApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "http://junior.balinasoft.com"

class NetworkService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val accountApi: AccountApi
        get() = retrofit.create()
}