package com.example.moviesapp.features.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviesapp.cores.utils.IMAGE_PATH_URL
import com.example.moviesapp.features.domain.entities.Movie

@Composable
fun ItemMovie(movie: Movie) {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        movie.path?.let { ImageItemMovie(path = it) }
        Column {
            movie.title?.let { Text(text = it) }
            movie.date?.let { Text(text = it) }
            movie.description?.let { Text(text = it) }
        }
    }
}

@Composable
fun ImageItemMovie(path: String) {
    AsyncImage(
        model = "$IMAGE_PATH_URL$path",
        contentDescription = "Image of movie item",
        modifier = Modifier.size(width = 25.dp, height = 25.dp)
    )
}