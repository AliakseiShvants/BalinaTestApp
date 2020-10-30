package com.shvants.balinatestapp.contract

import com.shvants.balinatestapp.presenter.BasePresenter

interface RegisterContract {

    interface View {
        fun register()
        fun setError(
            usernameError: String? = null,
            passwordError: String? = null,
            confirmPasswordError: String? = null
        )

        fun navigate(resId: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun validate(username: String, password: String, confirmPassword: String)
    }
}