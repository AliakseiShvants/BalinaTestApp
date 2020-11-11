package com.shvants.network.domain

interface ITokenHelper {

    val token: String

    fun saveToken(token: String)
}