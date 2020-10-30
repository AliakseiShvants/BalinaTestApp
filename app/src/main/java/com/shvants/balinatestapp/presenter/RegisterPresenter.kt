package com.shvants.balinatestapp.presenter

import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.contract.RegisterContract
import com.shvants.balinatestapp.repository.AccountRepository
import com.shvants.balinatestapp.util.Constant.Error.CONFIRM_PASSWORD_ERROR
import com.shvants.balinatestapp.util.Constant.Error.PASSWORD_ERROR
import com.shvants.balinatestapp.util.Constant.Error.USERNAME_ERROR
import com.shvants.balinatestapp.util.Constant.Error.USERNAME_EXISTS
import com.shvants.balinatestapp.util.Constant.Pattern.USERNAME_PATTERN
import com.shvants.balinatestapp.util.Constant.Range.PASSWORD_RANGE
import com.shvants.balinatestapp.util.Constant.Range.USERNAME_RANGE
import com.shvants.network.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.regex.Pattern
import kotlin.coroutines.CoroutineContext

class RegisterPresenter : RegisterContract.Presenter, KoinComponent, CoroutineScope {

    private val accountRepository: AccountRepository by inject()
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
                when (accountRepository.register(username, password)) {
                    is Result.Success -> view?.navigate(R.id.action_tabLayoutFragment_to_mainFragment)
                    is Result.Error -> view?.setError(USERNAME_EXISTS)
                }
            }
        } else {
            val usernameError = if (!isUsernameValid) USERNAME_ERROR else null
            val passwordError = if (!isPasswordValid) PASSWORD_ERROR else null
            val confirmPasswordError = if (!isConfirmPasswordValid) CONFIRM_PASSWORD_ERROR else null

            view?.setError(usernameError, passwordError, confirmPasswordError)
        }
    }

    private fun validateUsername(username: String): Boolean {
        val usernamePattern = Pattern.compile(USERNAME_PATTERN)
        val usernameMatcher = usernamePattern.matcher(username)

        return username.length in USERNAME_RANGE && usernameMatcher.matches()
    }
}