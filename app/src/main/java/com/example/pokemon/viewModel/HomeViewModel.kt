package com.example.pokemon.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.api.PokemonApi
import com.example.pokemon.model.Pokemon
import com.example.pokemon.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    private val _uiState = MutableSharedFlow<Pokemon>()
    val uiState = _uiState.asSharedFlow()
    fun getPokemonList() {
        //TODO: wait for api get pokemon list
        viewModelScope.launch {
            repository.getPokemon()
                .flowOn(Dispatchers.IO)
                .catch { Log.d(HomeViewModel::class.java.simpleName, "Error") }
                .collect {
                    _uiState.emit(it)
                }
        }
    }
}