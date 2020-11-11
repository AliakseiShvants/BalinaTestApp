package com.shvants.balinatestapp.domain.mvp.presenter

import com.shvants.balinatestapp.domain.mvp.contract.TabLayoutContract
import com.shvants.balinatestapp.util.Constant.Error.CONFIRM_PASSWORD_ERROR
import com.shvants.balinatestapp.util.Constant.Error.PASSWORD_ERROR
import com.shvants.balinatestapp.util.Constant.Error.USERNAME_ERROR
import com.shvants.balinatestapp.util.Constant.Pattern.USERNAME_PATTERN
import com.shvants.balinatestapp.util.Constant.Range.PASSWORD_RANGE
import com.shvants.balinatestapp.util.Constant.Range.USERNAME_RANGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.core.KoinComponent
import java.util.regex.Pattern
import kotlin.coroutines.CoroutineContext

abstract class TabLayoutPresenter : TabLayoutContract.Presenter, CoroutineScope, KoinComponent {

    private val job = Job()

    abstract var view: TabLayoutContract.View?

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun attachView(view: TabLayoutContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun validate(username: String, password: String, confirmPassword: String?): Boolean {
        val isUsernameValid = validateUsername(username)
        val isPasswordValid = password.length in PASSWORD_RANGE
        val isConfirmPasswordValid =
            if (confirmPassword != null) password == confirmPassword else true

        return if (isUsernameValid && isPasswordValid && isConfirmPasswordValid) {
            true
        } else {
            val usernameError = if (!isUsernameValid) USERNAME_ERROR else null
            val passwordError = if (!isPasswordValid) PASSWORD_ERROR else null
            val confirmPasswordError = if (!isConfirmPasswordValid) CONFIRM_PASSWORD_ERROR else null

            view?.setError(usernameError, passwordError, confirmPasswordError)

            false
        }
    }

    abstract override fun execute(username: String, password: String)

    private fun validateUsername(username: String): Boolean {
        val usernamePattern = Pattern.compile(USERNAME_PATTERN)
        val usernameMatcher = usernamePattern.matcher(username)

        return username.length in USERNAME_RANGE && usernameMatcher.matches()
    }
}