package com.rast.alquran.ui.navigation

sealed class Screens(
    val route: String,
){
    object Splash: Screens(route = "splash")
    object Chapters: Screens(route = "chapters")
    object Chapter: Screens(route = "chapter")
}
