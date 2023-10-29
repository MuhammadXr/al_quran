package com.rast.alquran.utils

fun numberToFormattedString(pageNumber: Int): String {
    return if (pageNumber < 10) "00$pageNumber" else if (pageNumber in 10..99) "0$pageNumber" else "$pageNumber"
}