package com.example.moviesapp.features.presentation.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.features.domain.entities.Movie
import com.example.moviesapp.features.domain.use_cases.GetMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class MoviesViewModel(private val getMoviesUseCase: GetMovies) : ViewModel() {
    var state = MutableStateFlow<StateMovies>(StateMovies.START)

    private var movies: List<Movie> by mutableStateOf(listOf())
    private var error : String by mutableStateOf("")
        init {
            state.value = StateMovies.START
        }
    fun getMovies(text: String) {
        viewModelScope.launch {
            try {
                movies = getMoviesUseCase.call(text = text)
                if(movies.isNotEmpty()) state.value = StateMovies.LOADED(movies= movies)
            } catch (e: Exception) {
                error = e.message.toString()
                state.value = StateMovies.FAILURE(message = error)
            }
        }
    }

}