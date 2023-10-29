package com.rast.alquran.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName




@Keep
data class Chapters(
    @SerializedName("chapters")
    val chapters: List<Chapter>
)

@Keep
data class Chapter(
    @SerializedName("bismillah_pre")
    val bismillahPre: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name_arabic")
    val nameArabic: String,
    @SerializedName("name_complex")
    val nameComplex: String,
    @SerializedName("name_simple")
    val nameSimple: String,
    @SerializedName("pages")
    val pages: List<Int>,
    @SerializedName("revelation_order")
    val revelationOrder: Int,
    @SerializedName("revelation_place")
    val revelationPlace: String,
    @SerializedName("translated_name")
    val translatedName: TranslatedName,
    @SerializedName("verses_count")
    val versesCount: Int
)

@Keep
data class TranslatedName(
    @SerializedName("language_name")
    val languageName: String,
    @SerializedName("name")
    val name: String
)

@Keep
data class ChapterInfo(
    @SerializedName("chapter_info")
    val chapterInfo: ChapterInfoX
)

@Keep
data class ChapterInfoX(
    @SerializedName("chapter_id")
    val chapterId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("language_name")
    val languageName: String,
    @SerializedName("short_text")
    val shortText: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("text")
    val text: String
)