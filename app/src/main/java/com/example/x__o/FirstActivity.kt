package com.example.x__o

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        var user1 = findViewById<EditText>(R.id.edituser1)
        var user2 = findViewById<EditText>(R.id.edituser2)
        var bttn = findViewById<Button>(R.id.btn)

        bttn.setOnClickListener {

            var User1 = user1.text.toString()
            var User2 = user2.text.toString()

            var changed = Intent(this, MainActivity::class.java).also {
                it.putExtra("player1", User1)
                it.putExtra("player2", User2)

            }

            startActivity(changed)

        }


    }
}