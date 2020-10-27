package com.shvants.network

import com.shvants.network.api.AccountApi
import retrofit2.Retrofit
import retrofit2.create

private const val BASE_URL = "http://junior.balinasoft.com/v2/api-docs?group=api1"

class NetworkService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

    val accountApi: AccountApi
        get() = retrofit.create()
}