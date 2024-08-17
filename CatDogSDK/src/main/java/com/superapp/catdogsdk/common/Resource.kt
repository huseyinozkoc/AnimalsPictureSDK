package com.superapp.catanddogsdk.common

sealed interface Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>
    data class Error(val throwable: Throwable) : Resource<Nothing>
    object Loading : Resource<Nothing>
}