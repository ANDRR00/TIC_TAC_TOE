package com.example.x__o


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetbutton: Button
    private lateinit var rename1:TextView
    private lateinit var rename2:TextView
    private lateinit var score2 : TextView
    private lateinit var score1 : TextView
    private var scoreFirst = 0
    private var scoreSecond = 0
    private var happy_end = 0
    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        init()

        resetbutton.setOnClickListener {
            reset()

            if(scoreFirst==3|| scoreSecond==3){
                scoreFirst=0
                scoreSecond=0
                score1.text= scoreFirst.toString()
                score2.text= scoreSecond.toString()

            }

        }

    }


    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetbutton = findViewById(R.id.resetbutton)
        score1=findViewById(R.id.textView4)
        score2=findViewById(R.id.textView5)


        val name1=intent.extras?.getString("player1")
        val name2=intent.extras?.getString("player2")

        rename1=findViewById(R.id.textView2)
        rename2=findViewById(R.id.textView3)

        rename1.text=name1
        rename2.text=name2






        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)




    }

    override fun onClick(ClickedView: View?) {
        if (ClickedView is Button){

            var buttonNumber = 0
            when (ClickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playGame(ClickedView, buttonNumber)
            }



        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.CYAN)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }
        else if (activePlayer == 2) {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.LTGRAY)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }

        clickedView.isEnabled = false
        if (happy_end == 0){
            check()
        }
        if (happy_end == 1) {
            activePlayer = 3
        }


    }

    private fun check(){
        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (winnerPlayer == 1) {
            scoreFirst += 1
            if(scoreFirst==3){
                Toast.makeText(this, "tamashi moigo X-ma", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "raundi moigo X-ma", Toast.LENGTH_SHORT).show()
            }
            happy_end = 1
            activePlayer = 3


            score1.text=scoreFirst.toString()



        }
        if (winnerPlayer == 2) {
            scoreSecond += 1
            if (scoreSecond==3){
                Toast.makeText(this, "tamashi moigo O-ma", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "raundi moigo O-ma", Toast.LENGTH_SHORT).show()
            }
            happy_end = 1
            activePlayer = 3


            score2.text = scoreSecond.toString()

        }
        if (firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0){
            Toast.makeText(this, "draw", Toast.LENGTH_SHORT).show()
        }



    }

    private fun reset() {
        firstPlayer.clear()
        secondPlayer.clear()

        button1.text = ""
        button1.setBackgroundColor(Color.BLUE)
        button2.text = ""
        button2.setBackgroundColor(Color.BLUE)
        button3.text = ""
        button3.setBackgroundColor(Color.BLUE)
        button4.text = ""
        button4.setBackgroundColor(Color.BLUE)
        button5.text = ""
        button5.setBackgroundColor(Color.BLUE)
        button6.text = ""
        button6.setBackgroundColor(Color.BLUE)
        button7.text = ""
        button7.setBackgroundColor(Color.BLUE)
        button8.text = ""
        button8.setBackgroundColor(Color.BLUE)
        button9.text = ""
        button9.setBackgroundColor(Color.BLUE)

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        activePlayer = 1

        happy_end = 0






    }





}