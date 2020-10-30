package com.shvants.network

import com.shvants.network.api.AccountApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

private const val BASE_URL = "http://junior.balinasoft.com"

class NetworkService {
    private val interceptor: Interceptor
        get() {
            return Interceptor { chain ->
                val request = chain.request()
                    .newBuilder()
//                    .addHeader(COOKIE, "$TOKEN_PREFIX$token")
                    .build()

                chain.proceed(request)
            }
        }
    private val client: OkHttpClient
        get() {
            val okHttpClient = OkHttpClient.Builder()
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY

            try {
                val trustAllCerts: Array<TrustManager> = arrayOf(object : X509TrustManager {
                    override fun checkClientTrusted(
                        chain: Array<out X509Certificate>?,
                        authType: String?
                    ) {
                    }

                    override fun checkServerTrusted(
                        chain: Array<out X509Certificate>?,
                        authType: String?
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
                })

                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())

                val sslSocketFactory = sslContext.socketFactory

                if (trustAllCerts.isNotEmpty() && trustAllCerts.first() is X509TrustManager) {
                    okHttpClient.sslSocketFactory(
                        sslSocketFactory,
                        trustAllCerts.first() as X509TrustManager
                    )
                    okHttpClient.hostnameVerifier { _, _ -> true }
                }

            } catch (e: Exception) {
            }

            return okHttpClient
//                .addInterceptor(interceptor)
//                .addInterceptor(logInterceptor)
                .build()
        }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val accountApi: AccountApi
        get() = retrofit.create()
}