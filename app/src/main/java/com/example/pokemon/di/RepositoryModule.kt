package com.example.pokemon.di

import com.example.pokemon.api.PokemonApi
import com.example.pokemon.repository.PokemonRepository
import com.example.pokemon.repository.PokemonRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun providePokemonRepository(pokemonApi: PokemonApi): PokemonRepository = PokemonRepositoryImp(pokemonApi)
}