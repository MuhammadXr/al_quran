package com.rast.alquran.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class Verses(
    @SerializedName("pagination")
    val pagination: Pagination?,
    @SerializedName("verses")
    val verses: List<Verse>?
)

@Keep
data class Pagination(
    @SerializedName("current_page")
    val currentPage: Int?,
    @SerializedName("next_page")
    val nextPage: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_records")
    val totalRecords: Int?
)

@Keep
data class Verse(
    @SerializedName("hizb_number")
    val hizbNumber: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("juz_number")
    val juzNumber: Int?,
    @SerializedName("page_number")
    val pageNumber: Int?,
    @SerializedName("rub_el_hizb_number")
    val rubElHizbNumber: Int?,
    @SerializedName("sajdah_number")
    val sajdahNumber: Any?,
    @SerializedName("sajdah_type")
    val sajdahType: Any?,
    @SerializedName("tafsirs")
    val tafsirs: List<Tafsir>?,
    @SerializedName("translations")
    val translations: List<Translation>?,
    @SerializedName("verse_key")
    val verseKey: String?,
    @SerializedName("verse_number")
    val verseNumber: Int?,
    @SerializedName("words")
    val words: List<Word>?
)

@Keep
data class Tafsir(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("language_name")
    val languageName: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("text")
    val text: String?
)

@Keep
data class Translation(
    @SerializedName("resource_id")
    val resourceId: Int?,
    @SerializedName("text")
    val text: String?
)

@Keep
data class Word(
    @SerializedName("audio_url")
    val audioUrl: String?,
    @SerializedName("char_type_name")
    val charTypeName: String?,
    @SerializedName("code_v1")
    val codeV1: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("line_number")
    val lineNumber: Int?,
    @SerializedName("page_number")
    val pageNumber: Int?,
    @SerializedName("position")
    val position: Int?,
    @SerializedName("translation")
    val translation: TranslationX?,
    @SerializedName("transliteration")
    val transliteration: Transliteration?
)

@Keep
data class TranslationX(
    @SerializedName("language_name")
    val languageName: String?,
    @SerializedName("text")
    val text: String?
)

@Keep
data class Transliteration(
    @SerializedName("language_name")
    val languageName: String?,
    @SerializedName("text")
    val text: String?
)