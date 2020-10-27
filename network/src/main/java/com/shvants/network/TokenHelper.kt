package com.shvants.network

import com.shvants.network.api.ITokenHelper

private const val TOKEN = "TOKEN"

class TokenHelper : ITokenHelper {

    private var _token: String = ""

    override val token: String
        get() = _token

    override fun saveToken(token: String) {
        _token = token
    }
}