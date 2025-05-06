package com.example.retrofitdogapp.network

data class Dog(
    val description: String,
    val title: String?,
    val imageUrl: String?,
    val genres: List<String> // Added to match the JSON structure
)