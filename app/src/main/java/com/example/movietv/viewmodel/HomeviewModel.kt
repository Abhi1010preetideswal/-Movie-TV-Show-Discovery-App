package com.example.movietv.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movietv.network.api.WatchmodeApi
import com.example.movietv.network.model.MovieOrShow
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable


class HomeViewModel(private val api: WatchmodeApi) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _movies = MutableLiveData<List<MovieOrShow>>()
    val movies: LiveData<List<MovieOrShow>> get() = _movies

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val baseUrl = "https://api.watchmode.com/v1/search/"
    private val apiKey = "WjOkFXMhndyW8rUXkaIP5oEm0iQrFbsdons3sovi"

    fun searchMovies(searchValue: String) {
        // Check for empty input
        if (searchValue.isBlank()) {
            _error.value = "Search value cannot be empty"
            return
        }

        // Clear previous results
        _movies.value = emptyList()

        // Construct and log the API URL
        val constructedUrl = "$baseUrl?apiKey=$apiKey&search_field=name&search_value=$searchValue"
        Log.d("API URL", constructedUrl)

        compositeDisposable.add(
            api.searchMovies(searchValue = searchValue)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response.title_results.isNotEmpty()) {
                        Log.d("API URL", "https://api.watchmode.com/v1/search/?apiKey=WjOkFXMhndyW8rUXkaIP5oEm0iQrFbsdons3sovi&search_field=name&search_value=$searchValue")
                        Log.d("API Response", response.title_results.toString())
                        _movies.value = response.title_results
                    } else {
                        _error.value = "No results found"
                    }
                }, { throwable ->
//                    error handle
                    Log.e("API Error", throwable.message ?: "Unknown error")
                    _error.value = throwable.message ?: "An unknown error occurred"
                })
        )
    }

    fun setError(message: String) {
        _error.value = message
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}





