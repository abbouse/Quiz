package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = ". : : $username : : ."
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val tv_score = findViewById<TextView>(R.id.tv_score)
        val tv_result = findViewById<TextView>(R.id.tv_result)
        if (correctAnswers == 11){
            tv_score.text = "Qoyil, siz berilgan barcha savollarga to'g'ri javob berdingiz!"
            tv_result.text = "{ DAXSHAT NATIJA }"
        }else if(correctAnswers in 6..10){
            tv_score.text = "Qoyil, siz $totalQuestions ta savoldan $correctAnswers tasiga to'g'ri javob berdingiz, yana harakat qilib ko'ring!"
            tv_result.text = "{ A'LO NATIJA }"
        }else if(correctAnswers in 1..6){
            tv_score.text = "Afsuski, siz $totalQuestions ta savoldan $correctAnswers tasiga to'g'ri javob berdingiz!"
            tv_result.text = "{ YAXSHI NATIJA }"
        }else if (correctAnswers == 0){
            tv_score.text = "Afsuski, siz berilgan $totalQuestions ta savolni barchasiga noto'g'ri javob berdingiz!"
            tv_result.text = "{ YOMON NATIJA }"
        }
        val laugh = findViewById<TextView>(R.id.tv_laugh)
        if (correctAnswers > 5){
            laugh.text = ":)"
        }else{
            laugh.text = ":("
        }
        val finish = findViewById<Button>(R.id.btn_finish)
        finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}