package com.peachgenz.mvvm.extension

import retrofit2.Response
import com.peachgenz.mvvm.model.Result

fun <T> Response<T>.toNetworkResult(): Result<T> {
    try {
        if (this.isSuccessful) {
            this.body()?.let {
                return Result.Success(it)
            } ?: run {
                return Result.Error(null)
            }
        } else {
            return Result.Error("Call api error")
        }
    } catch (ioException: Exception) {
        return Result.Error("ioException(call api)")
    }
}