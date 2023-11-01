package com.example.intempus.data.network.model

/**
 *                           NetworkResult<T>
 *                         /
 *                       /
 *  NetworkResponse<T>
 *                       \                   NetworkHttpError
 *                        \                /
 *                         NetworkNoResult - NetworkIOError
 */
sealed class NetworkResponse<out T : Any>

sealed class NetworkNoResult : NetworkResponse<Nothing>()

object NetworkIOError : NetworkNoResult()

class NetworkHttpError(val errorCode: Int) : NetworkNoResult()

class NetworkResult<out T : Any>(val result: T) : NetworkResponse<T>()