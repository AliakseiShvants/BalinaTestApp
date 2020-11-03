package com.shvants.balinatestapp.domain.usecase

import com.shvants.balinatestapp.domain.repository.IAccountRepository
import com.shvants.network.Result

class AccountUseCase(
    private val accountRepository: IAccountRepository
) : IAccountUseCase {

    override suspend fun register(login: String, password: String): Result<Boolean> {
        return accountRepository.register(login, password)
    }

    override suspend fun login(username: String, password: String): Result<Boolean> {
        return accountRepository.login(username, password)
    }
}