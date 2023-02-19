package com.r.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.r.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater). also { setContentView(it.root) }

        binding.rollButton.setOnClickListener { rollDice() }
    }

    // Rolls the dice and update the screen with the result.
    private fun rollDice(){

        val dice = Dice(6)

        // Determines which image to use based on the result of the dice roll
        val drawableResource = when (dice.roll()){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {R.drawable.ic_baseline_error}
        }

        // Updates the ImageView
        binding.diceImageView.setImageResource(drawableResource)
    }
}