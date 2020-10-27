package com.shvants.network.api

import com.shvants.network.entity.SignUserDtoIn
import com.shvants.network.entity.SignUserOutDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountApi {

    @POST("/api/account/signup")
    suspend fun register(@Body user: SignUserDtoIn): SignUserOutDto
}