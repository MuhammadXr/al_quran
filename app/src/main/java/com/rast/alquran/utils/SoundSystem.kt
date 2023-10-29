package com.rast.alquran.utils

import android.media.MediaPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class SoundSystem {
    val mediaPlayer: MediaPlayer = MediaPlayer()

    fun playUrlAudio(audioUrl: String) = runBlocking(Dispatchers.IO){
        try {
            mediaPlayer.reset()
            mediaPlayer.setDataSource(audioUrl)
            mediaPlayer.prepare()
            mediaPlayer.start()
        }catch (e: Exception){

        }
    }

    fun cleanAudio(){
        try {
            mediaPlayer.release()
        } catch (e: Exception) {

        }
    }
    fun stopAudio(){
        try {
            mediaPlayer.stop()
        } catch (e: Exception) {

        }
    }
}