package com.example.movietv.network.api

//import com.example.movietv.network.model.MovieOrShow
import com.example.movietv.network.model.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.rxjava3.core.Single


interface WatchmodeApi {
    @GET("v1/search/")
    fun searchMovies(
        @Query("search_field") searchField: String = "name",
        @Query("search_value") searchValue: String,
        @Query("apiKey") apiKey: String = "WjOkFXMhndyW8rUXkaIP5oEm0iQrFbsdons3sovi"
    ): Single<MovieSearchResponse>

}