package com.example.movietv.di

import com.example.movietv.network.api.WatchmodeApi
import com.example.movietv.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory // Correct import

val appModule = module {
    // Provide Retrofit instance
    single<WatchmodeApi> {
        Retrofit.Builder()
            .baseUrl("https://api.watchmode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Correctly referenced
            .build()
            .create(WatchmodeApi::class.java)
    }

    // Provide HomeViewModel
    viewModel { HomeViewModel(get()) }
}
