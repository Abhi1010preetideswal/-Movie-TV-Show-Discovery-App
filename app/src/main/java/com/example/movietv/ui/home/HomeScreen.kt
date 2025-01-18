package com.example.movietv.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movietv.viewmodel.HomeViewModel
import com.example.movietv.network.model.MovieOrShow
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {
    // Fetch movies when the composable is launched
    LaunchedEffect(Unit) {
        // Update to use the correct method in HomeViewModel
        viewModel.searchMovies("Inception") // Replace "Inception" with any movie name
    }

    val movies by viewModel.movies.observeAsState(emptyList())
    val error by viewModel.error.observeAsState("")

    Box(modifier = Modifier.fillMaxSize()) {
        if (movies.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn {
                items(movies) { movie ->
                    MovieItem(movie)
                }
            }
        }

        if (error.isNotEmpty()) {
            Snackbar(modifier = Modifier.align(Alignment.BottomCenter)) {
                Text(text = error)
            }
        }
    }
}







