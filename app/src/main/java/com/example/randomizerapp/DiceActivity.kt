package com.example.randomizerapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.randomizerapp.databinding.ActivityDiceBinding
import kotlin.random.Random

class DiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRoll.setOnClickListener {
            val result = Random.nextInt(1, 7)
            binding.textResult.text = result.toString()
            setDiceImage(result)
            animateDice()
        }

        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun setDiceImage(result: Int) {
        val imageRes = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
        binding.diceImage.setImageResource(imageRes)
    }

    private fun animateDice() {
        val rotate = RotateAnimation(0f, 360f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 500
        binding.diceImage.startAnimation(rotate)
    }
}
