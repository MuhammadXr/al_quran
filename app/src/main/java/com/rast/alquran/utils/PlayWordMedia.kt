package com.rast.alquran.utils

import android.util.Log

object PlayWordMedia {
    private val soundSystem = SoundSystem()
    private val wordBaseUrl = "https://audio.qurancdn.com/wbw/"

    fun playWord(chapterId: Int, verseId: Int, wordId: Int){


        val wordLink =
            wordBaseUrl +
            "${numberToFormattedString(chapterId)}_${numberToFormattedString(verseId)}_${numberToFormattedString(wordId)}" +
                    ".mp3"

        Log.d("TTT", "playWord: $wordLink")
        soundSystem.playUrlAudio(wordLink)

    }
}