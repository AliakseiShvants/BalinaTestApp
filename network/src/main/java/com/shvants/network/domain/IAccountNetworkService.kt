package com.shvants.network.domain

import com.shvants.network.data.entity.ResponseData
import com.shvants.network.data.entity.SignUserDtoIn
import retrofit2.http.Body
import retrofit2.http.HTTP

interface IAccountNetworkService {

    //    @POST("/api/account/signup")
    @HTTP(method = "POST", path = "/api/account/signup", hasBody = true)
    suspend fun register(@Body userDto: SignUserDtoIn): ResponseData

    @HTTP(method = "POST", path = "/api/account/signin", hasBody = true)
    suspend fun login(@Body userDto: SignUserDtoIn): ResponseData
}