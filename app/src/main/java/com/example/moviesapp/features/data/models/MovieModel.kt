package com.example.moviesapp.features.data.models

import com.example.moviesapp.features.domain.entities.Movie

data class MovieModel(
    var adult: Boolean?,
    var backdrop_path: String?,
    var genre_ids: List<Int>?,
    var id: Int,
    var original_language: String?,
    var original_title: String?,
    var overview: String?,
    var popularity: Double?,
    var poster_path: String?,
    var release_date: String?,
    var title: String?,
    var video: Boolean?,
    var vote_average: Double?,
    var vote_count: Int?
)

fun MovieModel.toEntity(): Movie {
    return Movie(
        id = this.id,
        title = this.original_title,
        path = this.poster_path,
        description = this.overview,
        date = this.release_date
    )
}