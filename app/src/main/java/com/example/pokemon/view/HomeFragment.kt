package com.example.pokemon.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.pokemon.PokemonCollectionActivity
import com.example.pokemon.PokemonDetailActivity
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentHomeBinding
import com.example.pokemon.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var  binding : FragmentHomeBinding

    val viewModel: HomeViewModel by viewModels()
//    val viewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch{
            viewModel.uiState.collect{
                Log.d(HomeFragment::class.java.simpleName, "$it")
            }
        }



        binding.PokeBall.setOnClickListener{
//            Log.e(MainActivity::class.java.simpleName, "on click")
//            val intent = Intent(context, PokemonDetailActivity::class.java)
//            intent.putExtra("Name", "Naravit")
//            startActivity(intent)
            viewModel.getPokemonList()
        }

        binding.BackPack.setOnClickListener{
            val action = R.id.action_homeFragment_to_pokemonCollectionFragment
//            val intent = Intent(context, PokemonCollectionActivity::class.java)
//            startActivity(intent)
            findNavController().navigate(action)
        }
    }
}