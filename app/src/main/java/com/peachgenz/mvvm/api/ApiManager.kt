package com.peachgenz.mvvm.api

import com.peachgenz.mvvm.api.service.NewsService
import com.peachgenz.mvvm.constant.BaseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager(
    private var networkClient: NetworkClient
) {
    private fun initRetrofit(baseUrl: String): Retrofit = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        client(networkClient.getClient())
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    fun news(): NewsService = initRetrofit(
        baseUrl = BaseUrl.URL
    ).create(NewsService::class.java)
}