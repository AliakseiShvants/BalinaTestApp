package com.shvants.balinatestapp.presenter

import com.shvants.balinatestapp.contract.RegisterContract
import com.shvants.balinatestapp.repository.AccountRepository
import com.shvants.balinatestapp.util.Constant.Pattern.USERNAME_PATTERN
import com.shvants.balinatestapp.util.Constant.Range.PASSWORD_RANGE
import com.shvants.balinatestapp.util.Constant.Range.USERNAME_RANGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import kotlin.coroutines.CoroutineContext

class RegisterPresenter(
    private val accountRepository: AccountRepository
) : RegisterContract.Presenter, CoroutineScope {

    private val job = Job()

    private var view: RegisterContract.View? = null

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun attachView(view: RegisterContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun validate(username: String, password: String, confirmPassword: String) {
        val isUsernameValid = validateUsername(username)
        val isPasswordValid = password.length in PASSWORD_RANGE
        val isConfirmPasswordValid = password == confirmPassword

        if (isUsernameValid && isPasswordValid && isConfirmPasswordValid) {
            launch {
                accountRepository.register(username, password)
            }
        }

        view?.setError(isUsernameValid, isPasswordValid, isConfirmPasswordValid)
    }

    private fun validateUsername(username: String): Boolean {
        val usernamePattern = Pattern.compile(USERNAME_PATTERN)
        val usernameMatcher = usernamePattern.matcher(username)

        return username.length in USERNAME_RANGE && usernameMatcher.matches()
    }
}