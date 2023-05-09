package com.project.young.ecommerce_mvvm.domain.util

sealed class Resource<out T> {

    object Loading: Resource<Nothing>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure<out T>(val exception: Exception): Resource<T>()
}