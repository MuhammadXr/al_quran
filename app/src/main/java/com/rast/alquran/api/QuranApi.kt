package com.rast.alquran.api

import com.rast.alquran.model.Chapter
import com.rast.alquran.model.ChapterInfo
import com.rast.alquran.model.Chapters
import com.rast.alquran.model.GlyphCodes
import com.rast.alquran.model.Verse
import com.rast.alquran.model.Verses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface QuranApi {
    @GET("chapters")
    suspend fun getChapters(): Response<Chapters>

    @GET("chapters/{id}")
    suspend fun getChapter(@Path("id") id: Int): Response<Chapter>

    @GET("chapters/{id}/info")
    suspend fun getChapterInfo(@Path("id") id: Int): Response<ChapterInfo>

    @GET("verses/by_chapter/{chapterNumber}")
    suspend fun getVersesByChapter(@Path("chapterNumber") chapterNumber: Int): Response<Verses>

    @GET("verses/by_page/{pageNumber}")
    suspend fun getVersesByPage(@Path("pageNumber") pageNumber: Int): Response<Verses>

    @GET("verses/by_juz/{juzNumber}")
    suspend fun getVersesByJuz(@Path("juzNumber") juzNumber: Int): Response<Verses>

    @GET("verses/by_hizb/{hizb_number}")
    suspend fun getVersesByHizb(@Path("hizb_number") hizbNumber: Int): Response<Verses>

    @GET("verses/by_rub/{rub_el_hizb_number}")
    suspend fun getVersesByRubElHizb(@Path("rub_el_hizb_number") rubElHizbNumber: Int): Response<Verses>

    @GET("verses/by_key/{verse_key}")
    suspend fun getSpecificVerseByKey(@Path("verse_key") verseKey: Int): Response<Verses>

    @GET("quran/verses/code_v2")
    suspend fun getGlyphCodesOfAyah(
        @Query("chapter_number") chapterNumber: Int?,
        @Query("juz_number") juzNumber: Int?,
        @Query("page_number") pageNumber: Int?,
        @Query("hizb_number") hizbNumber: Int?,
        @Query("verse_key") verseKey: Int?
    ): Response<GlyphCodes>

    @GET("verses/random")
    suspend fun getRandomAyah(): Response<Verse>


}