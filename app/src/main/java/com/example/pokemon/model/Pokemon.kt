package com.example.pokemon.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: Name,
    @SerializedName("type")
    val types: List<String>,
    @SerializedName("HP")
    val hp: Int,
    @SerializedName("Attack")
    val attack: Int,
    @SerializedName("Defense")
    val defense: Int,
    @SerializedName("Speed")
    val speed: Int,
    @SerializedName("iamgeUrl")
    val  imageUrl: String
)

data class Name(
    val english: String,
    val japanese: String
)

fun mockPokemonList(): List<Pokemon> =
    listOf(
        Pokemon(
            id = 1,
            name = Name(
                english = "Bulbasaur",
                japanese = "フシギダネ"
            ),
            types = listOf(
                "Grass",
                "Poison"
            ),
            hp = 45,
            attack = 49,
            defense = 49,
            speed = 45,
            imageUrl = "https://raw.githubusercontent.com/Purukitto/pokemon-data.json/master/images/pokedex/hires/001.png"
        ),
        Pokemon(
            id = 2,
            name = Name(
                english = "Ivysaur",
                japanese = "フシギソウ"
            ),
            types = listOf(
                "Grass",
                "Poison"
            ),
            hp = 60,
            attack = 62,
            defense = 63,
            speed = 60,
            imageUrl = "https://raw.githubusercontent.com/Purukitto/pokemon-data.json/master/images/pokedex/hires/002.png"
        ),
        Pokemon(
            id = 3,
            name = Name(
                english = "Venusaur",
                japanese = "フシギバナ"
            ),
            types = listOf(
                "Grass",
                "Poison"
            ),
            hp = 80,
            attack = 82,
            defense = 83,
            speed = 80,
            imageUrl = "https://raw.githubusercontent.com/Purukitto/pokemon-data.json/master/images/pokedex/hires/003.png"
        ),
    )