package com.example.randomizerapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.randomizerapp.databinding.ActivityCoinBinding
import kotlin.random.Random

class CoinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFlip.setOnClickListener {
            val isHeads = Random.nextBoolean()
            val result = if (isHeads) "Heads" else "Tails"
            binding.textResult.text = result
            setCoinImage(isHeads)
            animateCoin()
        }

        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun setCoinImage(isHeads: Boolean) {
        val imageRes = if (isHeads) {
            R.drawable.coin_heads
        } else {
            R.drawable.coin_tails
        }
        binding.coinImage.setImageResource(imageRes)
    }

    private fun animateCoin() {
        val rotate = RotateAnimation(0f, 360f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 500
        binding.coinImage.startAnimation(rotate)
    }
}
