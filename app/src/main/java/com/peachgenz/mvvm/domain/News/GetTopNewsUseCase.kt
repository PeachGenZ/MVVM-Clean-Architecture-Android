package com.peachgenz.mvvm.domain.News

import com.peachgenz.mvvm.domain.CoroutineNonParamUseCase
import com.peachgenz.mvvm.model.NewsResponse
import com.peachgenz.mvvm.model.Result
import com.peachgenz.mvvm.repository.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher

class GetTopNewsUseCase(
    private val newsRepository: NewsRepository,
    private val dispatcher: CoroutineDispatcher
): CoroutineNonParamUseCase<NewsResponse>(coroutineDispatcher = dispatcher) {
    override suspend fun execute(): Result<NewsResponse> {
        return newsRepository.getTopNews()
    }
}