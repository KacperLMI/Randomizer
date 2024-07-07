package com.example.randomizerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.randomizerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDice.setOnClickListener {
            startActivity(Intent(this, DiceActivity::class.java))
        }

        binding.buttonWheel.setOnClickListener {
            startActivity(Intent(this, WheelActivity::class.java))
        }

        binding.buttonCoin.setOnClickListener {
            startActivity(Intent(this, CoinActivity::class.java))
        }
    }
}
