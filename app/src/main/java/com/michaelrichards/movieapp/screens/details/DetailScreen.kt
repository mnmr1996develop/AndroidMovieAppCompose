package com.michaelrichards.movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.michaelrichards.movieapp.model.Movie
import com.michaelrichards.movieapp.model.getMovies
import com.michaelrichards.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController, movieId: String?){

    val movie = getMovies().first {
        it.id == movieId
    }

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Red, elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back", modifier = Modifier.clickable {  navController.popBackStack() })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies", color = Color.White)
            }

        }
    }) {
        Surface(modifier = Modifier.fillMaxSize(), ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                MovieRow(movie = movie)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Movie Images")
                HorizontalScrollableImageView(movie)
            }
        }
    }




}

@Composable
private fun HorizontalScrollableImageView(movie: Movie) {
    LazyRow {
        items(movie.images.size) {
            Card(
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(12.dp)
                    .size(240.dp), elevation = 5.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = movie.images[it]),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}