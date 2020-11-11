package com.shvants.network.domain

import com.shvants.network.data.entity.CommentDtoIn
import com.shvants.network.data.entity.CommentDtoOut
import com.shvants.network.data.entity.ResponseDto
import retrofit2.http.*

interface CommentService {

    @GET("/api/image/{imageId}/comment")
    suspend fun getComment(
        @Query("page") page: Int,
        @Path("imageId") imageId: Int
    ): ResponseDto<List<CommentDtoOut>>

    @HTTP(method = "POST", path = "/api/image/{imageId}/comment", hasBody = true)
    suspend fun saveComment(
        @Path("imageId") imageId: Int,
        @Body comment: CommentDtoIn
    ): ResponseDto<CommentDtoOut>

    @HTTP(method = "DELETE", path = "/api/image/{imageId}/comment/{commentId}")
    suspend fun deleteComment(
        @Path("imageId") imageId: Int,
        @Path("commentId") commentId: Int
    ): ResponseDto<CommentDtoOut>
}