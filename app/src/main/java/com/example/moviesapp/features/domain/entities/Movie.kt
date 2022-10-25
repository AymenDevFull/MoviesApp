package com.example.moviesapp.features.domain.entities

data class Movie(
    val id: Int,
    val title: String?,
    val path: String?,
    val description: String?,
    val date: String?
)