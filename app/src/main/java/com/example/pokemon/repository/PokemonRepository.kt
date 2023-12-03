package com.example.pokemon.repository

import com.example.pokemon.api.PokemonApi
import com.example.pokemon.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface PokemonRepository {
    suspend fun getPokemon(): Flow<Pokemon>
}

class PokemonRepositoryImp @Inject constructor(
    private val pokemonApi: PokemonApi
): PokemonRepository{

    override suspend fun getPokemon(): Flow<Pokemon> {

        val response = pokemonApi.getPokemonList()
        return if (response.isSuccessful){
            val pokemon = response.body()?.random()
            if (pokemon == null) {
                flow { throw Exception() }
            }
            else{
                flow{ emit(pokemon) }
            }
        } else {
            flow { throw Exception() }
        }
    }

}