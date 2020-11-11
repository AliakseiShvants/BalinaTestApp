package com.shvants.balinatestapp.data.repository

import com.shvants.network.Result
import com.shvants.network.data.entity.SignUserDtoIn
import com.shvants.network.domain.AccountService
import com.shvants.network.domain.ITokenHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class AccountRepository : KoinComponent {

    private val accountService: AccountService by inject()
    private val tokenHelper: ITokenHelper by inject()

    suspend fun register(login: String, password: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val user = accountService.register(SignUserDtoIn(login, password)).data
                tokenHelper.saveToken(user.token)

                Result.Success(true)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    suspend fun login(login: String, password: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val user = accountService.login(SignUserDtoIn(login, password)).data
                tokenHelper.saveToken(user.token)

                Result.Success(true)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}