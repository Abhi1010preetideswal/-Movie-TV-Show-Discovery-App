package com.example.movietv.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import com.example.moviesapp.model.MovieOrShow
import com.example.movietv.network.model.MovieOrShow

@Composable
fun DetailsScreen(movie: MovieOrShow) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = movie.name ?: "Unknown name", style = MaterialTheme.typography.h6)
        Text(text = "id: ${movie.id ?: "Unknown"}")
        Text(text = "year: ${movie.year ?: "Unknown"}")
    }
}
