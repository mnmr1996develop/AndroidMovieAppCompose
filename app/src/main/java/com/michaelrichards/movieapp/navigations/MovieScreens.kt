package com.michaelrichards.movieapp.navigations

enum class MovieScreens {
    HOMESCREEN, DETAILSCREEN;

    companion object{
        fun fromRoute(route: String?) : MovieScreens
        = when(route?.substringBefore("/")){
            HOMESCREEN.name -> HOMESCREEN
            DETAILSCREEN.name -> DETAILSCREEN
            null -> HOMESCREEN
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}