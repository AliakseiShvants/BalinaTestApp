package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.domain.mvp.contract.RegisterContract
import com.shvants.balinatestapp.domain.mvp.contract.TabLayoutContract
import com.shvants.balinatestapp.domain.usecase.IAccountUseCase
import com.shvants.balinatestapp.util.Constant
import com.shvants.network.Result
import kotlinx.coroutines.launch

class RegisterPresenter(
    private val accountUseCase: IAccountUseCase
) : TabLayoutPresenter(accountUseCase), RegisterContract.Presenter {

    override var view: TabLayoutContract.View? = null

    override fun execute(username: String, password: String) {
        launch {
            when (accountUseCase.register(username, password)) {
                is Result.Success -> view?.navigate()
                is Result.Error -> view?.setError(Constant.Error.SIGN_UP_ALREADY_IN_USE)
            }
        }
    }
}