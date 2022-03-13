package com.peachgenz.mvvm.api

import com.peachgenz.mvvm.BuildConfig
import com.peachgenz.mvvm.utils.HttpPrettyLogger
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class NetworkClient() {

    fun getClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(30, TimeUnit.SECONDS)
            connectTimeout(30, TimeUnit.SECONDS)
            if(BuildConfig.DEBUG){
                addInterceptor(getHttpLoggingInterceptor())
            }
        }.build()
    }

    private fun getHttpLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor(HttpPrettyLogger())
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}