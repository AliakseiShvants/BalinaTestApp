package com.shvants.network.domain

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "http://junior.balinasoft.com"

class NetworkService(
    private val tokenHelper: ITokenHelper
) {
    private val interceptor: Interceptor
        get() {
            return Interceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("Access-Token", tokenHelper.token)
                    .build()

                chain.proceed(request)
            }
        }
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
        .build()

    val accountService: AccountService
        get() = retrofit.create()

    val imageService: ImageService
        get() = retrofit.create()

    val commentService: CommentService
        get() = retrofit.create()
}