package com.michaelrichards.movieapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.michaelrichards.movieapp.model.Movie
import com.michaelrichards.movieapp.model.getMovies
import com.michaelrichards.movieapp.navigations.MovieScreens
import com.michaelrichards.movieapp.widgets.MovieRow

private const val TAG = "HomeScreen"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "Movies")
            }
        }
    ) {
        MainContent(navController = navController)
    }
}


@Composable
fun MainContent(navController: NavController ,movieList: List<Movie> = getMovies()) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it){movie ->
                    //Log.i(TAG, "MainContent: $movie")
                    navController.navigate(route = MovieScreens.DETAILSCREEN.name + "/$movie")
                }
            }
        }
    }

}


