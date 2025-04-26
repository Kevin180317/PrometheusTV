package com.example.prometheustv

data class DetailInfo(
    val description: String,
    val additionalInfo: String,
    val imageResId: Int,
    val additionalImageResId: Int? = null, // Opcional
    val extraImageResId1: Int? = null,     // Otra imagen opcional
    val extraImageResId2: Int? = null,     // Otra imagen opcional
    val extraNotes: String? = null         // Texto adicional opcional
)
