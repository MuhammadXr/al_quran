package com.rast.alquran.ui.screens.chapters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rast.alquran.ui.base.Screen
import com.rast.alquran.ui.theme.AlQuranTheme
import com.rast.alquran.viewmodel.ChaptersViewModel

class ChaptersScreen(val navController: NavHostController): Screen {
    @Composable
    override fun Content() {
        ChaptersScreenContent(navController = navController)
    }
}

@Composable
fun ChaptersScreenContent(
    viewModel: ChaptersViewModel = hiltViewModel(),
    navController: NavHostController
){

    LaunchedEffect(key1 = true, block = {
        viewModel.initNavController(navController)
    })

    AlQuranTheme {
        val chapters = viewModel.chapters.collectAsState()

        Column(Modifier.fillMaxSize()) {
            Text(text = "Chapters")
            LazyColumn(){
                chapters.value?.let {
                    items(it.chapters){
                        Row(modifier = Modifier
                            .clickable {
                                viewModel.gotoChapter(chapterId = it.id)
                            }
                            .padding(24.dp)
                            .fillMaxWidth()) {
                            Text(text = it.nameSimple)
                        }
                    }
                }
            }
        }
    }
}