package com.example.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // สร้างตัวแปร binding จริงๆตัวแปรชื่ออื่นได้แต่ธรรมเนียมใช้ชื่อนี้ ขึ้นมา type ชื่อเดียวกับ layout แต่ตัวใหญ่ (Android studio จะแนะนำให้)
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.PokeBall.setOnClickListener{
//            Log.e(MainActivity::class.java.simpleName, "on click")
            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtra("Name", "Naravit")
            startActivity(intent)
        }

        binding.BackPack.setOnClickListener{
            val intent = Intent(this, PokemonCollectionActivity::class.java)
            startActivity(intent)
        }
    }
}

