package com.shvants.balinatestapp.domain.usecase

import com.shvants.network.Result

interface IAccountUseCase {

    suspend fun register(login: String, password: String): Result<Boolean>

    suspend fun login(username: String, password: String): Result<Boolean>
}