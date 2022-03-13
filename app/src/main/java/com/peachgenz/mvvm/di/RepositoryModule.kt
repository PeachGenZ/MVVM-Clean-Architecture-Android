package com.peachgenz.mvvm.di

import com.peachgenz.mvvm.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { NewsRepository(get()) }
}