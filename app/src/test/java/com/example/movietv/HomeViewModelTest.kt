package com.example.movietv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.movietv.network.api.WatchmodeApi
import com.example.movietv.network.model.MovieOrShow
import com.example.movietv.network.model.MovieSearchResponse
import com.example.movietv.viewmodel.HomeViewModel
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var api: WatchmodeApi
    private val mockMoviesObserver: Observer<List<MovieOrShow>> =
        mock(Observer::class.java) as Observer<List<MovieOrShow>>
    private val mockErrorObserver: Observer<String> = mock(Observer::class.java) as Observer<String>

    @Before
    fun setup() {
        api = mock(WatchmodeApi::class.java)
        viewModel = HomeViewModel(api)
        viewModel.movies.observeForever(mockMoviesObserver)
        viewModel.error.observeForever(mockErrorObserver)
    }

    @Test
    fun testEmptySearch() {
        viewModel.searchMovies("")
        verify(mockErrorObserver).onChanged("Search value cannot be empty")
    }

    @Test
    fun testConstructedUrl() {
        val searchValue = "Inception"
        val mockResponse = MovieSearchResponse(emptyList(), emptyList())
        `when`(api.searchMovies(searchValue = searchValue)).thenReturn(Single.just(mockResponse))

        viewModel.searchMovies(searchValue)
        verify(api).searchMovies(searchValue)
    }

    @Test
    fun testSuccessfulApiResponse() {
        val searchValue = "Inception"
        val mockResponse = MovieSearchResponse(
            title_results = listOf(
                MovieOrShow("Inception", "2010", "Sci-Fi", "https://image.url"),
                MovieOrShow("The Dark Knight", "2008", "Action", "https://image.url")
            ),
            people_results = emptyList()
        )
        `when`(api.searchMovies(searchValue = searchValue)).thenReturn(Single.just(mockResponse))

        viewModel.searchMovies(searchValue)
        verify(mockMoviesObserver).onChanged(mockResponse.title_results)
    }

    @Test
    fun testEmptyApiResponse() {
        val searchValue = "Inception"
        val mockResponse = MovieSearchResponse(emptyList(), emptyList())
        `when`(api.searchMovies(searchValue = searchValue)).thenReturn(Single.just(mockResponse))

        viewModel.searchMovies(searchValue)
        verify(mockErrorObserver).onChanged("No results found")
    }

    @Test
    fun testApiErrorHandling() {
        val searchValue = "Inception"
        val exception = RuntimeException("Network error")
        `when`(api.searchMovies(searchValue = searchValue)).thenReturn(Single.error(exception))

        viewModel.searchMovies(searchValue)
        verify(mockErrorObserver).onChanged("Network error")
    }

    @Test
    fun testClearingResults() {
        val mockResponse = MovieSearchResponse(
            title_results = listOf(MovieOrShow("Titanic", "2010", "Sci-Fi", "https://image.url")),
            people_results = emptyList()
        )
        `when`(api.searchMovies(searchValue = "Titanic")).thenReturn(Single.just(mockResponse))

        viewModel.searchMovies("Titanic")
        verify(mockMoviesObserver).onChanged(mockResponse.title_results)

        `when`(api.searchMovies(searchValue = "Avatar")).thenReturn(Single.just(mockResponse))
        viewModel.searchMovies("Avatar")
        verify(api).searchMovies("Avatar")
    }
}
