package com.peachgenz.mvvm

import android.app.Application
import com.peachgenz.mvvm.di.appModule
import com.peachgenz.mvvm.di.repositoryModule
import com.peachgenz.mvvm.di.useCaseModule
import com.peachgenz.mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplication(): Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin(){
        startKoin{
            androidContext(this@MainApplication)
            modules(
                appModule,
                viewModelModule,
                useCaseModule,
                repositoryModule
            )
        }
    }

    private fun setupTimber(){
        Timber.plant(Timber.DebugTree())
    }
}