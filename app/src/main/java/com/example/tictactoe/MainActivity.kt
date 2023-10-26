package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //val binding = ActivityMultiplayerBinding.inflate(layoutInflater)
    lateinit var binding: ActivityMainBinding
    var flag = 0
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.newGame.setOnClickListener {
            newGameBtn()
        }
    }

    fun check(view: View){

        //Reference for the current button
        val btnCurrent = view as Button

        //This condition prevents users from clicking and changing the value of a button that's already filled with X or O
        if(btnCurrent.text == "") {

            count++

            val btn1 = binding.btn1.text.toString()
            val btn2 = binding.btn2.text.toString()
            val btn3 = binding.btn3.text.toString()
            val btn4 = binding.btn4.text.toString()
            val btn5 = binding.btn5.text.toString()
            val btn6 = binding.btn6.text.toString()
            val btn7 = binding.btn7.text.toString()
            val btn8 = binding.btn8.text.toString()
            val btn9 = binding.btn9.text.toString()

            //Logic for toggling mechanism
            //When flag value is 0 and a button is clicked we print X and then change the flag value to 1 to start the toggle mechanism
            //When flag value is 1 and a button is clicked we print O and then change the flag value to 0 to keep doing the toggle mechanism
            if (flag == 0) {
                btnCurrent.text = "X"
                binding.result.text = "Player Two's Turn"
                flag = 1
            } else {
                btnCurrent.text = "O"
                flag = 0
                binding.result.text = "Player One's Turn"
            }

            //For checking the winning conditions row-wise, we need to make sure that the text of the three buttons present in a row are same.
            //But we also have to make sure that the text values of those buttons are not empty strings because it would cause a logical error in the program and
            //a user will win before the game even starts
            if (btn1 == btn2 && btn2 == btn3 && btn1 != "") {
                binding.result.text = "Winner is: $btn3"
                newGame()
            } else if (btn4 == btn5 && btn5 == btn6 && btn4 != "") {
                binding.result.text = "Winner is: $btn4"
                newGame()
            } else if (btn7 == btn8 && btn8 == btn9 && btn7 != "") {
                binding.result.text = "Winner is: $btn7"
                newGame()
            } else if (btn1 == btn4 && btn4 == btn7 && btn7 != "") {
                binding.result.text = "Winner is: $btn7"
                newGame()
            } else if (btn2 == btn5 && btn5 == btn8 && btn2 != "") {
                binding.result.text = "Winner is: $btn2"
                newGame()
            } else if (btn3 == btn6 && btn6 == btn9 && btn9 != "") {
                binding.result.text = "Winner is: $btn9"
                newGame()
            } else if (btn1 == btn5 && btn5 == btn9 && btn7 != "") {
                binding.result.text = "Winner is: $btn5"
                newGame()
            } else if (btn3 == btn5 && btn5 == btn7 && btn7 != "") {
                binding.result.text = "Winner is: $btn7"
                newGame()
            } else if(count == 9) {
                binding.result.text = "Match is drawn"
                newGame()
            }

        }

    }

    private fun newGame(){
        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
        flag = 0
        count = 0
    }

    private fun newGameBtn(){
        newGame()
        binding.result.text = "Player One's Turn"
    }
}