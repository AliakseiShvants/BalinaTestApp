package com.shvants.network.api

import com.shvants.network.entity.ResponseData
import com.shvants.network.entity.SignUserDtoIn
import retrofit2.http.Body
import retrofit2.http.HTTP

interface AccountApi {

    //    @POST("/api/account/signup")
    @HTTP(method = "POST", path = "/api/account/signup", hasBody = true)
    suspend fun register(@Body userDto: SignUserDtoIn): ResponseData

    @HTTP(method = "POST", path = "/api/account/signin", hasBody = true)
    suspend fun login(@Body userDto: SignUserDtoIn): ResponseData
}