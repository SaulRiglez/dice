package com.yoprogramo.diceroller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var rollButton: Button
    lateinit var resultImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       initViews();

        rollButton.setOnClickListener {
            resultImage.setImageResource(setDrawable(rollDice()))
        }
    }

    private fun initViews() {
        rollButton = findViewById(R.id.roll_button)
        resultImage = findViewById(R.id.dice_image)
    }

    private fun setDrawable(rollDice: Int) = when (rollDice) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.empty_dice
    }

    private fun rollDice() = Random().nextInt(6) + 1
}
