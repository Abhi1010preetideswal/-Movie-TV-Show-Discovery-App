package com.example.movietv

import com.example.movietv.network.api.WatchmodeApi
import com.example.movietv.network.model.MovieSearchResponse
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WatchmodeApiTest {

    private val api: WatchmodeApi = Retrofit.Builder()
        .baseUrl("https://api.watchmode.com/v1/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WatchmodeApi::class.java)

    @Test
    fun testSearchMoviesApi() {
        val searchValue = "Titanic"
        val response: Single<MovieSearchResponse> = api.searchMovies(searchValue = searchValue)
        response.test().assertComplete().assertNoErrors()
    }

}
