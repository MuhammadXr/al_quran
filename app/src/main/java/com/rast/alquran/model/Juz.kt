package com.rast.alquran.model
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


@Keep
data class Juzs(
    @SerializedName("juzs")
    val juzs: List<Juz?>?
)

@Keep
data class Juz(
    @SerializedName("first_verse_id")
    val firstVerseId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("juz_number")
    val juzNumber: Int?,
    @SerializedName("last_verse_id")
    val lastVerseId: Int?,
    @SerializedName("verse_mapping")
    val verseMapping: VerseMapping?,
    @SerializedName("verses_count")
    val versesCount: Int?
)

@Keep
data class VerseMapping(
    @SerializedName("1")
    val x1: String?,
    @SerializedName("10")
    val x10: String?,
    @SerializedName("100")
    val x100: String?,
    @SerializedName("101")
    val x101: String?,
    @SerializedName("102")
    val x102: String?,
    @SerializedName("103")
    val x103: String?,
    @SerializedName("104")
    val x104: String?,
    @SerializedName("105")
    val x105: String?,
    @SerializedName("106")
    val x106: String?,
    @SerializedName("107")
    val x107: String?,
    @SerializedName("108")
    val x108: String?,
    @SerializedName("109")
    val x109: String?,
    @SerializedName("11")
    val x11: String?,
    @SerializedName("110")
    val x110: String?,
    @SerializedName("111")
    val x111: String?,
    @SerializedName("112")
    val x112: String?,
    @SerializedName("113")
    val x113: String?,
    @SerializedName("114")
    val x114: String?,
    @SerializedName("12")
    val x12: String?,
    @SerializedName("13")
    val x13: String?,
    @SerializedName("14")
    val x14: String?,
    @SerializedName("15")
    val x15: String?,
    @SerializedName("16")
    val x16: String?,
    @SerializedName("17")
    val x17: String?,
    @SerializedName("18")
    val x18: String?,
    @SerializedName("19")
    val x19: String?,
    @SerializedName("2")
    val x2: String?,
    @SerializedName("20")
    val x20: String?,
    @SerializedName("21")
    val x21: String?,
    @SerializedName("22")
    val x22: String?,
    @SerializedName("23")
    val x23: String?,
    @SerializedName("24")
    val x24: String?,
    @SerializedName("25")
    val x25: String?,
    @SerializedName("26")
    val x26: String?,
    @SerializedName("27")
    val x27: String?,
    @SerializedName("28")
    val x28: String?,
    @SerializedName("29")
    val x29: String?,
    @SerializedName("3")
    val x3: String?,
    @SerializedName("30")
    val x30: String?,
    @SerializedName("31")
    val x31: String?,
    @SerializedName("32")
    val x32: String?,
    @SerializedName("33")
    val x33: String?,
    @SerializedName("34")
    val x34: String?,
    @SerializedName("35")
    val x35: String?,
    @SerializedName("36")
    val x36: String?,
    @SerializedName("37")
    val x37: String?,
    @SerializedName("38")
    val x38: String?,
    @SerializedName("39")
    val x39: String?,
    @SerializedName("4")
    val x4: String?,
    @SerializedName("40")
    val x40: String?,
    @SerializedName("41")
    val x41: String?,
    @SerializedName("42")
    val x42: String?,
    @SerializedName("43")
    val x43: String?,
    @SerializedName("44")
    val x44: String?,
    @SerializedName("45")
    val x45: String?,
    @SerializedName("46")
    val x46: String?,
    @SerializedName("47")
    val x47: String?,
    @SerializedName("48")
    val x48: String?,
    @SerializedName("49")
    val x49: String?,
    @SerializedName("5")
    val x5: String?,
    @SerializedName("50")
    val x50: String?,
    @SerializedName("51")
    val x51: String?,
    @SerializedName("52")
    val x52: String?,
    @SerializedName("53")
    val x53: String?,
    @SerializedName("54")
    val x54: String?,
    @SerializedName("55")
    val x55: String?,
    @SerializedName("56")
    val x56: String?,
    @SerializedName("57")
    val x57: String?,
    @SerializedName("58")
    val x58: String?,
    @SerializedName("59")
    val x59: String?,
    @SerializedName("6")
    val x6: String?,
    @SerializedName("60")
    val x60: String?,
    @SerializedName("61")
    val x61: String?,
    @SerializedName("62")
    val x62: String?,
    @SerializedName("63")
    val x63: String?,
    @SerializedName("64")
    val x64: String?,
    @SerializedName("65")
    val x65: String?,
    @SerializedName("66")
    val x66: String?,
    @SerializedName("67")
    val x67: String?,
    @SerializedName("68")
    val x68: String?,
    @SerializedName("69")
    val x69: String?,
    @SerializedName("7")
    val x7: String?,
    @SerializedName("70")
    val x70: String?,
    @SerializedName("71")
    val x71: String?,
    @SerializedName("72")
    val x72: String?,
    @SerializedName("73")
    val x73: String?,
    @SerializedName("74")
    val x74: String?,
    @SerializedName("75")
    val x75: String?,
    @SerializedName("76")
    val x76: String?,
    @SerializedName("77")
    val x77: String?,
    @SerializedName("78")
    val x78: String?,
    @SerializedName("79")
    val x79: String?,
    @SerializedName("8")
    val x8: String?,
    @SerializedName("80")
    val x80: String?,
    @SerializedName("81")
    val x81: String?,
    @SerializedName("82")
    val x82: String?,
    @SerializedName("83")
    val x83: String?,
    @SerializedName("84")
    val x84: String?,
    @SerializedName("85")
    val x85: String?,
    @SerializedName("86")
    val x86: String?,
    @SerializedName("87")
    val x87: String?,
    @SerializedName("88")
    val x88: String?,
    @SerializedName("89")
    val x89: String?,
    @SerializedName("9")
    val x9: String?,
    @SerializedName("90")
    val x90: String?,
    @SerializedName("91")
    val x91: String?,
    @SerializedName("92")
    val x92: String?,
    @SerializedName("93")
    val x93: String?,
    @SerializedName("94")
    val x94: String?,
    @SerializedName("95")
    val x95: String?,
    @SerializedName("96")
    val x96: String?,
    @SerializedName("97")
    val x97: String?,
    @SerializedName("98")
    val x98: String?,
    @SerializedName("99")
    val x99: String?
)