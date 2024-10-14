package com.kg.cryptocurrencytracker.common

/**
 * It is a sealed class that represents a network response.
 *  It has three subclasses: Success, Error, and Loading. The Success class holds the data,
 *  the Error class holds the error message, and the Loading class is used to indicate that the data is still loading.
 *  @param data It is a generic type that represents the data.
 *  @param message It is a string that represents the message.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}