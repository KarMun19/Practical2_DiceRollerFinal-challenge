/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var total : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
        total = findViewById(R.id.totalNum)
        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
            val toast = Toast.makeText(applicationContext, "Lim Kar Mun\n18WMR12145", Toast.LENGTH_LONG)
            toast.show()
        }

    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        val dice1 = getRandomDiceImage()
        val dice2 = getRandomDiceImage()
        diceImage.setImageResource(dice1)
        diceImage2.setImageResource(dice2)

        val num1 = getNum(dice1)
        val num2 = getNum(dice2)
        val result = (num1+num2).toString()
        total.text = result
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun getNum(dice:Int) : Int {
        return when (dice) {
            R.drawable.dice_1 -> 1
            R.drawable.dice_2 -> 2
            R.drawable.dice_3 -> 3
            R.drawable.dice_4 -> 4
            R.drawable.dice_5 -> 5
            else -> 6
        }
    }

}

