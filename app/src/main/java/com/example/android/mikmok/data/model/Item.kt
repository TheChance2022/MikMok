package com.example.android.mikmok.data.model

data class Item(
    val art: String,
    val description: String,
    val director: String,
    val duration: Int,
    val id: String,
    val ratings: List<String>,
    val title: String,
    val url: String,
    val year: Int
)