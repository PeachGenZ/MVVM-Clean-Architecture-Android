package com.peachgenz.mvvm.repository

import com.peachgenz.mvvm.api.service.NewsService
import com.peachgenz.mvvm.extension.toNetworkResult
import com.peachgenz.mvvm.model.NewsResponse
import com.peachgenz.mvvm.model.Result

class NewsRepository(
    private val newsService: NewsService
) {
    suspend fun getTopNews(): Result<NewsResponse> {
        return newsService.getTopHeadlines().toNetworkResult()
    }
}