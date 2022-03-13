package com.peachgenz.mvvm.ui.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.peachgenz.mvvm.model.Result

abstract class BaseViewModel: ViewModel() {

    val uiState = MediatorLiveData<UIState>()

    protected fun <T> LiveData<Result<T>>.handleResponseResult(
        successHandler: (T) -> Unit,
        errorHandler: ((String?) -> Unit)? = null
    ) = handleResponseResult(uiState, successHandler, errorHandler)

    protected fun <T> LiveData<Result<T>>.handleResponseResult(
        uiState: MediatorLiveData<UIState>,
        successHandler: (T) -> Unit,
        errorHandler: ((String?) -> Unit)? = null
    ) {
        uiState.addSource(this) {
            when (it) {
                is Result.Loading -> {
                    uiState.value = Loading
                }
                is Result.Error -> {
                    errorHandler?.invoke(it.errorResponse)
                    uiState.value = ServerError( "Call api error")
                    uiState.removeSource(this)
                }
                is Result.Success -> {
                    successHandler(it.data)
                    uiState.value = HasData
                    uiState.removeSource(this)
                }
            }
        }
    }

}