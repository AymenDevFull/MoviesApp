package com.example.moviesapp.features.domain.repository

import com.example.moviesapp.features.domain.entities.Movie

interface MoviesRepository {
    suspend fun getMovies(text: String): List<Movie>
}