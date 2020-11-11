package com.shvants.network.domain

import com.shvants.network.data.entity.ImageDtoIn
import com.shvants.network.data.entity.ImageDtoOut
import com.shvants.network.data.entity.ResponseDto
import retrofit2.http.*

interface ImageService {

    @GET("/api/image")
    suspend fun getImage(@Query("page") page: Int): ResponseDto<List<ImageDtoOut>>

    @HTTP(method = "POST", path = "/api/image", hasBody = true)
    suspend fun saveImage(@Body image: ImageDtoIn): ResponseDto<ImageDtoOut>

    @HTTP(method = "DELETE", path = "/api/image/{id}")
    suspend fun deleteImage(@Path("id") id: Int): ResponseDto<ImageDtoOut>
}