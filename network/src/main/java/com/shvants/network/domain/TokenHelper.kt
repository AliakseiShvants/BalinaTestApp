package com.shvants.network.domain

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

private const val TOKEN = "TOKEN"
private const val PREFS = "PREFS"

class TokenHelper(context: Context) : ITokenHelper {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS, MODE_PRIVATE)

    private var _token: String?

    override val token: String?
        get() = _token

    init {
        _token = sharedPreferences.getString(TOKEN, null)
    }

    override fun saveToken(token: String?) {
        _token = token
        setString(TOKEN, token)
    }

    private fun setString(key: String, value: String?) {
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }
}