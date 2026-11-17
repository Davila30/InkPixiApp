package com.example.inkpiki.artDetails

import java.util.Locale

data class Artwork(
    val id: String,
    val title: String,
    val description: String,
    val price: Double?,
    val authorName: String,
    val imageUrl: String?,
    val category: String
)

val Artwork.priceLabel: String
    get() = price?.let { String.format(Locale.forLanguageTag("es-ES"), "%.2f €", it) }
        ?: "No está a la venta"