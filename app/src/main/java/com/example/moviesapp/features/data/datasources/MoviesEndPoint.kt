package com.example.moviesapp.features.data.datasources

import com.example.moviesapp.features.data.models.MoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesEndPoint {

    @GET("search/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MoviesListResponse
}