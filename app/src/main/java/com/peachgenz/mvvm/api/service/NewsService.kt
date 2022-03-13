package com.peachgenz.mvvm.api.service

import com.peachgenz.mvvm.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("token") token: String = "827dfb498a75ca4a319e63afa814bfea",
        @Query("lang") lang: String = "en",
    ): Response<NewsResponse>
}