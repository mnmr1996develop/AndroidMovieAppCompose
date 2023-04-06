package com.michaelrichards.movieapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.michaelrichards.movieapp.screens.details.DetailScreen
import com.michaelrichards.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HOMESCREEN.name) {

        composable(MovieScreens.HOMESCREEN.name) {
            HomeScreen(navController)
        }


        composable(
            MovieScreens.DETAILSCREEN.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) {backStackEntry ->

            DetailScreen(navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}