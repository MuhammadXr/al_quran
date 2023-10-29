package com.rast.alquran.repository.impl

import com.rast.alquran.api.QuranApi
import com.rast.alquran.model.Chapter
import com.rast.alquran.model.ChapterInfo
import com.rast.alquran.model.Chapters
import com.rast.alquran.model.GlyphCodes
import com.rast.alquran.model.Verse
import com.rast.alquran.model.Verses
import com.rast.alquran.repository.QuranRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val quranApi: QuranApi
) : QuranRepository{

    override suspend fun getChapters(): Flow<Chapters?> = flow {
        try {
            val response = quranApi.getChapters()
            if (response.isSuccessful){
                emit(response.body())
            }else{
                emit(null)
            }
        }catch (e: Exception){
            emit(null)
        }
    }

    override suspend fun getChapter(id: Int): Flow<Chapter?>  = flow {
        try {
            val response = quranApi.getChapter(id = id)
            if (response.isSuccessful){
                emit(response.body())
            }else{
                emit(null)
            }
        }catch (e: Exception){
            emit(null)
        }
    }

    override suspend fun getChapterInfo(id: Int): Flow<ChapterInfo?>  = flow {
        try {
            val response = quranApi.getChapterInfo(id = id)
            if (response.isSuccessful){
                emit(response.body())
            }else{
                emit(null)
            }
        }catch (e: Exception){
            emit(null)
        }
    }

    override suspend fun getVersesByChapter(chapterNumber: Int): Flow<Verses?>  = flow {
        try {
            val response = quranApi.getVersesByChapter(chapterNumber = chapterNumber)
            if (response.isSuccessful){
                emit(response.body())
            }else{
                emit(null)
            }
        }catch (e: Exception){
            emit(null)
        }
    }

    override suspend fun getVersesByPage(pageNumber: Int): Flow<Verses?>  = flow {
        try {
            val response = quranApi.getVersesByPage(pageNumber = pageNumber)
            if (response.isSuccessful){
                emit(response.body())
            }else{
                emit(null)
            }
        }catch (e: Exception){
            emit(null)
        }
    }

    override suspend fun getVersesByJuz(juzNumber: Int): Flow<Verses?>  = flow {
        try {
            val response = quranApi.getVersesByJuz(juzNumber = juzNumber)
            if (response.isSuccessful){
                emit(response.body())
            }else{
                emit(null)
            }
        }catch (e: Exception){
            emit(null)
        }
    }

    override suspend fun getVersesByHizb(hizbNumber: Int): Flow<Verses?> {
        TODO("Not yet implemented")
    }

    override suspend fun getVersesByRubElHizb(rubElHizbNumber: Int): Flow<Verses?> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpecificVerseByKey(verseKey: Int): Flow<Verses?> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomAyah(): Flow<Verse?> {
        TODO("Not yet implemented")
    }

    override suspend fun getGlyphCodesOfAyah(
        chapterNumber: Int?,
        juzNumber: Int?,
        pageNumber: Int?,
        hizbNumber: Int?,
        verseKey: Int?
    ): Flow<GlyphCodes?> = flow {
        val response = quranApi.getGlyphCodesOfAyah(chapterNumber, juzNumber, pageNumber, hizbNumber, verseKey)

        if (response.isSuccessful){
            emit(response.body())
        }else{
            emit(null)
        }
    }.catch {
        emit(null)
    }


}