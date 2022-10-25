package com.example.moviesapp.features.domain.use_cases

import com.example.moviesapp.features.domain.entities.Movie
import com.example.moviesapp.features.domain.repository.MoviesRepository

class GetMovies(private val moviesRepository: MoviesRepository) {

    suspend fun call(text: String): List<Movie> {
        return moviesRepository.getMovies(text = text)
    }
}