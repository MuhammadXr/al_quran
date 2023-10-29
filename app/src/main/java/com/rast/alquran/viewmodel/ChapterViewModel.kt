package com.rast.alquran.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rast.alquran.api.FontDownloadManager
import com.rast.alquran.model.GlyphCodes
import com.rast.alquran.repository.QuranRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChapterViewModel @Inject constructor(
    private val repository: QuranRepository
): ViewModel() {
    val verses = MutableStateFlow<GlyphCodes?>(null)
    val downloadProgress = MutableStateFlow<Int>(0)
    val isFontExist = MutableStateFlow<Boolean?>(null)
    val fontPath = MutableStateFlow(mutableMapOf<Int, String>())
    val pageNumber = MutableStateFlow<Int?>(null)

    init {
        viewModelScope.launch {  }
    }

    suspend fun setPageNumber(pageNumber: Int){
        this.pageNumber.value = pageNumber
    }

    suspend fun getVersesByChapter(chapterId: Int, context: Context){
        viewModelScope.launch(Dispatchers.IO){

            repository.getGlyphCodesOfAyah(chapterId).collect{
                var page = 0
                verses.value = it
                it?.let {
                    it.verses?.forEach { verseGlyph ->
                        verseGlyph?.v2Page?.let { v2Page ->
                            if (v2Page > page){
                                fontPath.value[v2Page] =
                                    FontDownloadManager.getFontPathOrEmpty(v2Page, context)
                                if (fontPath.value[v2Page]?.isEmpty() == true){
                                    isFontExist.value = false
                                    FontDownloadManager.downloadFont(pageNumber = v2Page, context).collect{ pathOrProgress ->
                                        if (pathOrProgress.contains('%')){
                                            downloadProgress.value = pathOrProgress.split('%').last().toInt()
                                        }
                                        else{
                                            if (pathOrProgress.isNotEmpty()){
                                                fontPath.value[v2Page]= pathOrProgress
                                                isFontExist.value = true
                                            }
                                        }
                                    }
                                }else{
                                    isFontExist.value = true
                                }
                            }
                            page = v2Page
                        }

                    }
                }
            }
        }
    }
}