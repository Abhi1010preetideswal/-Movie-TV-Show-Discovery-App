package com.example.movietv.network.model


data class MovieSearchResponse(
    val title_results: List<MovieOrShow>,
    val people_results: List<Any> // Adjust type as needed
)
