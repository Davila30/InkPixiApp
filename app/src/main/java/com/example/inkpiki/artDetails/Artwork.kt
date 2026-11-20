package com.example.inkpiki.artDetails

import java.util.Locale

data class Artwork(
    val id: String,
    val title: String,
    val description: String,
    val authorName: String,
    val imageUrl: String?,
    val category: String
)