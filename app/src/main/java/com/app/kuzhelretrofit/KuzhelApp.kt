package com.app.kuzhelretrofit

import android.app.Application
import com.app.kuzhelretrofit.ui.viewmodel.RecycleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KuzhelApp:Application() {
    override fun onCreate() {
        super.onCreate()
        //dependency injection для додатку
        startKoin {
            androidContext(this@KuzhelApp)
            androidLogger()
            modules(myModule)
        }

    }

    private val myModule = module {
        viewModel { RecycleViewModel(get()) }
    }
}