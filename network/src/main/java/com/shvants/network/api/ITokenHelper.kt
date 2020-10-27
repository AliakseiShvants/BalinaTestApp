package com.shvants.network.api

interface ITokenHelper {

    val token: String

    fun saveToken(token: String)
}