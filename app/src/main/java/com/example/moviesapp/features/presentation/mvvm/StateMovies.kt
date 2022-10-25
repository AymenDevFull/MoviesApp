package com.example.moviesapp.features.presentation.mvvm

import com.example.moviesapp.features.domain.entities.Movie

sealed class StateMovies {
    object START : StateMovies()
    data class LOADED(val movies: List<Movie>) : StateMovies()
    data class FAILURE(val message:String) : StateMovies()

}