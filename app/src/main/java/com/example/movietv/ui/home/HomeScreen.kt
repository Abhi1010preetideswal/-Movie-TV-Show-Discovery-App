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
import com.example.movietv.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // Search Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Search for movies...") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.searchMovies(searchQuery) }) {
                Text("Search")
            }
        }

        val movies by viewModel.movies.observeAsState(emptyList())
        val error by viewModel.error.observeAsState("")
        val loading by rememberUpdatedState(false)

        Box(modifier = Modifier.fillMaxSize()) {
            // Loading spinner
            if (loading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            // Show movies or an empty message if no results
            if (!loading && movies.isNotEmpty()) {
                LazyColumn(modifier = Modifier.padding(8.dp)) {
                    items(movies) { movie ->
                        MovieItem(movie)
                    }
                }
            } else if (!loading && error.isEmpty() && movies.isEmpty()) {
                Text(
                    text = "No results found",
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.h6
                )
            }

            // Show error message in a Snackbar
            if (error.isNotEmpty()) {
                Snackbar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    action = {
                        TextButton(onClick = { viewModel.setError("") }) {
                            Text("Dismiss")
                        }
                    }
                ) {
                    Text(text = error)
                }
            }
        }
    }
}
