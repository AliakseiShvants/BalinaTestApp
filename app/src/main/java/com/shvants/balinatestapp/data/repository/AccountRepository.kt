package com.shvants.balinatestapp.data.repository

import com.shvants.balinatestapp.domain.repository.IAccountRepository
import com.shvants.network.Result
import com.shvants.network.data.entity.SignUserDtoIn
import com.shvants.network.domain.IAccountNetworkService
import com.shvants.network.domain.ITokenHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class AccountRepository : IAccountRepository, KoinComponent {

    private val accountService: IAccountNetworkService by inject()
    private val tokenHelper: ITokenHelper by inject()

    override suspend fun register(login: String, password: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val user = accountService.register(SignUserDtoIn(login, password)).user
                tokenHelper.saveToken(user.token)

                Result.Success(true)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun login(login: String, password: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val user = accountService.login(SignUserDtoIn(login, password)).user
                tokenHelper.saveToken(user.token)

                Result.Success(true)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}