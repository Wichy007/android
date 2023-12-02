package com.example.pokemon.model

data class Pokemon(
    val id: Int,
    val name: Name,
    val types: List<String>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val  imageUrl: String
)

data class Name(
    val english: String,
    val japanese: String
)