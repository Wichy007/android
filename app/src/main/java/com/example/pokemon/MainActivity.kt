package com.example.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.pokemon.api.PokemonApi
import com.example.pokemon.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // สร้างตัวแปร binding จริงๆตัวแปรชื่ออื่นได้แต่ธรรมเนียมใช้ชื่อนี้ ขึ้นมา type ชื่อเดียวกับ layout แต่ตัวใหญ่ (Android studio จะแนะนำให้)
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var  commonLog: CommonLog

    @Inject lateinit var pokemonApi: PokemonApi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        commonLog.logCommon()
        lifecycleScope.launch {
            val list = pokemonApi.getPokemonList()
        }

//        binding.PokeBall.setOnClickListener{
////            Log.e(MainActivity::class.java.simpleName, "on click")
//            val intent = Intent(this, PokemonDetailActivity::class.java)
//            intent.putExtra("Name", "Naravit")
//            startActivity(intent)
//        }
//
//        binding.BackPack.setOnClickListener{
//            val intent = Intent(this, PokemonCollectionActivity::class.java)
//            startActivity(intent)
//        }
    }
}

