package com.example.movietv

import android.app.Application
import com.example.movietv.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieTVApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieTVApp)
            modules(appModule)
        }
    }
}



