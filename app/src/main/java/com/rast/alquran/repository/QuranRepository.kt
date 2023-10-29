package com.rast.alquran.repository

import com.rast.alquran.model.Chapter
import com.rast.alquran.model.ChapterInfo
import com.rast.alquran.model.Chapters
import com.rast.alquran.model.GlyphCodes
import com.rast.alquran.model.Verse
import com.rast.alquran.model.Verses
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Query

interface QuranRepository {
    suspend fun getChapters(): Flow<Chapters?>
    suspend fun getChapter(id: Int): Flow<Chapter?>
    suspend fun getChapterInfo(id: Int): Flow<ChapterInfo?>
    suspend fun getVersesByChapter(chapterNumber: Int): Flow<Verses?>
    suspend fun getVersesByPage(pageNumber: Int): Flow<Verses?>
    suspend fun getVersesByJuz(juzNumber: Int): Flow<Verses?>
    suspend fun getVersesByHizb(hizbNumber: Int): Flow<Verses?>
    suspend fun getVersesByRubElHizb(rubElHizbNumber: Int): Flow<Verses?>
    suspend fun getSpecificVerseByKey(verseKey: Int): Flow<Verses?>
    suspend fun getRandomAyah(): Flow<Verse?>
    suspend fun getGlyphCodesOfAyah(
        chapterNumber: Int? = null,
        juzNumber: Int? = null,
        pageNumber: Int? = null,
        hizbNumber: Int? = null,
        verseKey: Int? = null
    ): Flow<GlyphCodes?>
}