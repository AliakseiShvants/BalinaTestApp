package com.shvants.network

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
}