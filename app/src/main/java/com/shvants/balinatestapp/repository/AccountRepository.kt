package com.shvants.balinatestapp.repository

import com.shvants.network.Result
import com.shvants.network.api.AccountApi
import com.shvants.network.api.ITokenHelper
import com.shvants.network.entity.SignUserDtoIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountRepository(
    private val accountApi: AccountApi,
    private val tokenHelper: ITokenHelper
) {

    suspend fun register(login: String, password: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val user = accountApi.register(SignUserDtoIn(login, password)).user
                tokenHelper.saveToken(user.token)

                Result.Success(true)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    suspend fun login(username: String, password: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val user = accountApi.login(SignUserDtoIn(username, password)).user
                tokenHelper.saveToken(user.token)

                Result.Success(true)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}