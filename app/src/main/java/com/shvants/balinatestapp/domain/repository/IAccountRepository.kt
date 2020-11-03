package com.shvants.balinatestapp.domain.repository

import com.shvants.network.Result

interface IAccountRepository {

    suspend fun register(login: String, password: String): Result<Boolean>

    suspend fun login(login: String, password: String): Result<Boolean>
}