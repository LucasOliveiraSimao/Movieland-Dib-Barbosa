package com.lucassimao.movielanddibbarbosa.core

interface CallbackHelper<T> {
    fun onSuccess(result: T)
    fun onError(error: String)
}