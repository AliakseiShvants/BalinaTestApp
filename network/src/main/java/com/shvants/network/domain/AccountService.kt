package com.shvants.network.domain

import com.shvants.network.data.entity.ResponseDto
import com.shvants.network.data.entity.SignUserDtoIn
import com.shvants.network.data.entity.SignUserOutDto
import retrofit2.http.Body
import retrofit2.http.HTTP

interface AccountService {

    //    @POST("/api/account/signup")
    @HTTP(method = "POST", path = "/api/account/signup", hasBody = true)
    suspend fun register(@Body userDto: SignUserDtoIn): ResponseDto<SignUserOutDto>

    @HTTP(method = "POST", path = "/api/account/signin", hasBody = true)
    suspend fun login(@Body userDto: SignUserDtoIn): ResponseDto<SignUserOutDto>
}