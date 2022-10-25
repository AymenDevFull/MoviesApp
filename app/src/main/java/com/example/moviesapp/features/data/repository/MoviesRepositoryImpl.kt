package com.example.moviesapp.features.data.repository

import com.example.moviesapp.cores.utils.API_KEY
import com.example.moviesapp.features.data.datasources.MoviesEndPoint
import com.example.moviesapp.features.data.models.toEntity
import com.example.moviesapp.features.domain.entities.Movie
import com.example.moviesapp.features.domain.repository.MoviesRepository

class MoviesRepositoryImpl(private val moviesEndPoint: MoviesEndPoint) : MoviesRepository {
    override suspend fun getMovies(text: String): List<Movie> {
        return moviesEndPoint.getMovies(query = text, apiKey = API_KEY).results.map { it.toEntity() }
    }

}