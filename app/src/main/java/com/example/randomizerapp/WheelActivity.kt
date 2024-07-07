package com.example.randomizerapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.randomizerapp.databinding.ActivityWheelBinding
import kotlin.random.Random

class WheelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWheelBinding
    private val items = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWheelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAddItem.setOnClickListener {
            val newItem = binding.editTextItem.text.toString()
            if (newItem.isNotEmpty()) {
                items.add(newItem)
                binding.editTextItem.text.clear()
                updateItemsTextView()
            } else {
                Toast.makeText(this, "Please enter an item", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSpin.setOnClickListener {
            if (items.isNotEmpty()) {
                val randomIndex = Random.nextInt(items.size)
                val result = items[randomIndex]
                binding.textResult.text = result
                animateWheel()
            } else {
                Toast.makeText(this, "Please add items to the wheel", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun updateItemsTextView() {
        binding.textItems.text = items.joinToString(separator = ", ")
    }

    private fun animateWheel() {
        val rotate = RotateAnimation(0f, 360f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 1000
        binding.textResult.startAnimation(rotate)
    }
}
