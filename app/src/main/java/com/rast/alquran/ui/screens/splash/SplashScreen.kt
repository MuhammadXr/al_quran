package com.rast.alquran.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.rast.alquran.ui.base.Screen
import com.rast.alquran.ui.navigation.Screens

class SplashScreen(val navController: NavHostController): Screen {
    @Composable
    override fun Content() {
        LaunchedEffect(key1 = true, block = {
            navController.clearBackStack(Screens.Splash.route)
            navController.navigate(Screens.Chapters.route)
        })

    }
}