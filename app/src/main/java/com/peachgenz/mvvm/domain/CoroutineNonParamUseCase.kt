package com.peachgenz.mvvm.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext
import com.peachgenz.mvvm.model.Result

abstract class CoroutineNonParamUseCase<R>(private val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(
        context: CoroutineContext,
    ): LiveData<Result<R>> =
        liveData(context + coroutineDispatcher) {
            emit(Result.Loading)
            val result = execute()
            emit(result)
        }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(): Result<R>
}
