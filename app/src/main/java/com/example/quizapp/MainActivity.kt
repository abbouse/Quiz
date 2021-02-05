
package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login = findViewById<Button>(R.id.btn_start)
        login.setOnClickListener {
            val username = findViewById<EditText>(R.id.et_name)
            if (username.text.toString().isEmpty()) {
                Toast.makeText(this, "Iltimos ismingizni kiriting!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, username.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}