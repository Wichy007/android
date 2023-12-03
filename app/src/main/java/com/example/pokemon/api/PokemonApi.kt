package com.example.pokemon.api

import com.example.pokemon.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemons")
    suspend fun getPokemonList(): Response<List<Pokemon>>
}