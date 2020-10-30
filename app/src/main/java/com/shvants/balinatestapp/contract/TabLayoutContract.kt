package com.shvants.balinatestapp.contract

import com.shvants.balinatestapp.presenter.BasePresenter

interface TabLayoutContract {

    interface View {
        fun setError(
            usernameError: String? = null,
            passwordError: String? = null,
            confirmPasswordError: String? = null
        )

        fun navigate()
    }

    interface Presenter : BasePresenter<View> {
        fun validate(username: String, password: String, confirmPassword: String? = null): Boolean
        fun execute(username: String, password: String)
    }
}