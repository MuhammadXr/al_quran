package com.rast.alquran.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.rast.alquran.model.Chapters
import com.rast.alquran.repository.QuranRepository
import com.rast.alquran.ui.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChaptersViewModel @Inject constructor(
    private val repository: QuranRepository
): ViewModel() {


    val chapters = MutableStateFlow<Chapters?>(null)
    lateinit var navigator: NavHostController


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getChapters().collect{
                chapters.value = it
            }
        }
    }

    fun initNavController(navHostController: NavHostController){
        navigator = navHostController
    }

    fun gotoChapter(chapterId: Int) {
        navigator.navigate(Screens.Chapter.route+"/$chapterId")
    }
}