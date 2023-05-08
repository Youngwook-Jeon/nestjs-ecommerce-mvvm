package com.project.young.ecommerce_mvvm.domain.util

sealed class Response<out T> {

    object Loading: Response<Nothing>()
    data class Success<out T>(val data: T): Response<T>()
    data class Failure<out T>(val exception: Exception): Response<T>()
}
