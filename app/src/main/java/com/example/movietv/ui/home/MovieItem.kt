package com.example.movietv.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
//import com.example.moviesapp.model.MovieOrShow
import com.example.movietv.network.model.MovieOrShow

@Composable
fun MovieItem(movie: MovieOrShow) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = movie.poster ?: "https://via.placeholder.com/100",
//                error = painterResource(R.drawable.placeholder_image)
            ),
            contentDescription = movie.name,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 8.dp)
        )
        Column {
            Text(
                text = movie.name ?: "Unknown Title",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "id: ${movie.id ?: "Unknown"}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "year: ${movie.year ?: "Unknown"}")
        }
    }
}

