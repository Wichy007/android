package com.example.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemon.adapter.PokemonAdapter
import com.example.pokemon.databinding.ActivityPokemonCollectionBinding
import com.example.pokemon.model.mockPokemonList

class PokemonCollectionActivity : AppCompatActivity() {
    lateinit var binding: ActivityPokemonCollectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pokemon_collection)
        binding = ActivityPokemonCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PokemonAdapter(mockPokemonList())
        binding.pokemonRecycleView.adapter = adapter
    }
}