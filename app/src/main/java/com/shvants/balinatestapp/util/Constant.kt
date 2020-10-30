package com.shvants.balinatestapp.util

object Constant {
    object Error {
        const val USERNAME_ERROR = "Username must be between 4 and 32 characters"
        const val USERNAME_EXISTS = "This username already exists"
        const val PASSWORD_ERROR = "Password must be between 8 and 500 characters"
        const val CONFIRM_PASSWORD_ERROR = "Password and confirm password must be equals"
    }

    object Pattern {
        const val USERNAME_PATTERN = "[a-z0-9_\\-.@]+"
    }

    object Range {
        val USERNAME_RANGE = 4..32
        val PASSWORD_RANGE = 8..500
    }
}