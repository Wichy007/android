package com.example.pokemon.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemon.R
import com.example.pokemon.adapter.PokemonAdapter
import com.example.pokemon.databinding.ActivityPokemonCollectionBinding
import com.example.pokemon.databinding.FragmentPokemonCollectionBinding
import com.example.pokemon.model.mockPokemonList

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonCollectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonCollectionFragment : Fragment() {
    private lateinit var binding: FragmentPokemonCollectionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPokemonCollectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PokemonAdapter(mockPokemonList())
        binding.pokemonRecycleView.adapter = adapter
    }

}