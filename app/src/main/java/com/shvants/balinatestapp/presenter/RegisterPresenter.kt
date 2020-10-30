package com.shvants.balinatestapp.presenter

import com.shvants.balinatestapp.contract.TabLayoutContract
import com.shvants.balinatestapp.util.Constant
import com.shvants.network.Result
import kotlinx.coroutines.launch

class RegisterPresenter : TabLayoutPresenter() {

    override var view: TabLayoutContract.View? = null

    override fun execute(username: String, password: String) {
        launch {
            when (accountRepository.register(username, password)) {
                is Result.Success -> view?.navigate()
                is Result.Error -> view?.setError(Constant.Error.SIGN_UP_ALREADY_IN_USE)
            }
        }
    }
}