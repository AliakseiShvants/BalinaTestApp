package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.data.repository.AccountRepository
import com.shvants.balinatestapp.domain.mvp.contract.LoginContract
import com.shvants.balinatestapp.domain.mvp.contract.TabLayoutContract
import com.shvants.balinatestapp.util.Constant
import com.shvants.network.Result
import kotlinx.coroutines.launch

class LoginPresenter(
    private val accountRepository: AccountRepository
) : TabLayoutPresenter(), LoginContract.Presenter {

    override var view: TabLayoutContract.View? = null

    override fun execute(username: String, password: String) {
        launch {
            when (accountRepository.login(username, password)) {
                is Result.Success -> view?.navigate(username)
                is Result.Error -> view?.setError(Constant.Error.SIGN_IN_INCORRECT)
            }
        }
    }
}