package com.example.moviesapp.features.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.moviesapp.features.presentation.mvvm.MoviesViewModel
import com.example.moviesapp.features.presentation.mvvm.StateMovies
import com.example.moviesapp.features.presentation.ui.ui.theme.MoviesAppTheme
import com.example.moviesapp.features.presentation.widgets.ItemMovie


class HomeMovies : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MoviesViewModel by viewModels()
        setContent {
            MoviesAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar {
                            TextEditor(viewModel = viewModel)
                        }
                    }
                ) {
                    MoviesList(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun TextEditor(viewModel: MoviesViewModel) {
    var input = ""
    TextField(
        value = input,
        onValueChange = { text ->
            input = text
            viewModel.getMovies(text = text)
        }
    )
}


@Composable
fun MoviesList(viewModel: MoviesViewModel) {
    val state: StateMovies by viewModel.state.collectAsState()
    when (state) {
        StateMovies.START -> {
            Text("EMPTY ")
        }
        is StateMovies.LOADED -> {
            LazyColumn {
                items((state as StateMovies.LOADED).movies) { item ->
                    ItemMovie(movie = item)
                }
            }
        }
        is StateMovies.FAILURE -> {
            Text("NOT MOVIES TO SHOW")
        }
    }

}

