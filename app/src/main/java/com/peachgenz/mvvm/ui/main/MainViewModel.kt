package com.peachgenz.mvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.peachgenz.mvvm.domain.news.GetTopNewsUseCase
import com.peachgenz.mvvm.model.NewsResponse
import com.peachgenz.mvvm.ui.core.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val getTopNewsUseCase: GetTopNewsUseCase
) : BaseViewModel() {

    private val _getTopNewsUseCaseSuccess = MutableLiveData<NewsResponse?>()
    val getTopNewsUseCaseSuccess: LiveData<NewsResponse?>
        get() = _getTopNewsUseCaseSuccess

    fun getTopNews() = viewModelScope.launch {
        getTopNewsUseCase(context = coroutineContext).handleResponseResult(
            successHandler = {
                _getTopNewsUseCaseSuccess.value = it
            },
            errorHandler = {}
        )
    }
}