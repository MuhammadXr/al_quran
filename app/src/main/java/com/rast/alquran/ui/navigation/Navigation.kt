package com.rast.alquran.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rast.alquran.ui.screens.chapter.ChapterScreen
import com.rast.alquran.ui.screens.chapters.ChaptersScreen
import com.rast.alquran.ui.screens.splash.SplashScreen

@Composable
fun SetupGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.Splash.route){
        composable(
            route = Screens.Splash.route,
        ){
            SplashScreen(navController = navController).Content()
        }
        composable(route = Screens.Chapters.route){
            ChaptersScreen(navController = navController).Content()
        }
        composable(
            route = Screens.Chapter.route+"/{chapterId}",
            arguments = listOf(
                navArgument("chapterId"){
                    type = NavType.IntType
                }
            )
            ){
            ChapterScreen(
                chapterId = it.arguments!!.getInt("chapterId"),
                navHostController = navController
            ).Content()
        }
    }
}