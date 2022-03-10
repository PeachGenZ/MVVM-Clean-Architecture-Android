package com.peachgenz.mvvm.di

import com.peachgenz.mvvm.api.NetworkClient
import org.koin.dsl.module

val appModule = module {
    factory { NetworkClient() }
}