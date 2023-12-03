package com.example.pokemon.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.PokemonCardItemBinding
import com.example.pokemon.model.Pokemon

class PokemonViewHolder(
    private val binding: PokemonCardItemBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(pokemon: Pokemon){
        binding.PokemonName.text = pokemon.name.english
        binding.pokemonType.text = pokemon.types.joinToString (",")
        binding.pokemonImage
    }
}