package com.peachgenz.mvvm.di

import com.peachgenz.mvvm.domain.News.GetTopNewsUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetTopNewsUseCase(get(), Dispatchers.IO) }
}