package com.shvants.balinatestapp.contract

import com.shvants.balinatestapp.presenter.BasePresenter

interface RegisterContract {

    interface View {
        fun login()
        fun setError(
            isUsernameValid: Boolean,
            isPasswordValid: Boolean,
            isConfirmPasswordValid: Boolean
        )
    }

    interface Presenter : BasePresenter<View> {
        fun validate(username: String, password: String, confirmPassword: String)
    }
}