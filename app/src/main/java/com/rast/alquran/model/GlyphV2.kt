package com.rast.alquran.model
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


@Keep
data class GlyphCodes(
    @SerializedName("meta")
    val meta: Meta?,
    @SerializedName("verses")
    val verses: List<VerseGlyph?>?
)

@Keep
data class Meta(
    @SerializedName("filters")
    val filters: Filters?
)

@Keep
data class VerseGlyph(
    @SerializedName("code_v2")
    val codeV2: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("v2_page")
    val v2Page: Int?,
    @SerializedName("verse_key")
    val verseKey: String?
)

@Keep
data class Filters(
    @SerializedName("chapter_number")
    val chapterNumber: String?
)