package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList = Constants.getQuestions()
        setQuestion()
        val tv_optionone = findViewById<TextView>(R.id.tv_optionone)
        tv_optionone.setOnClickListener(this)
        val tv_optiontwo = findViewById<TextView>(R.id.tv_optiontwo)
        tv_optiontwo.setOnClickListener(this)
        val tv_optionthree = findViewById<TextView>(R.id.tv_optionthree)
        tv_optionthree.setOnClickListener(this)
        val tv_optionfour = findViewById<TextView>(R.id.tv_optionfour)
        tv_optionfour.setOnClickListener(this)
        val btn_select = findViewById<Button>(R.id.btn_select)
        btn_select.setOnClickListener(this)
    }



    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        val btn_select = findViewById<Button>(R.id.btn_select)
        if (mCurrentPosition == mQuestionsList!!.size){
            btn_select.text = "FINISH"
        }else{
            btn_select.text = "TANLASH"
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = mCurrentPosition
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max
        val tv_question = findViewById<TextView>(R.id.tv_question)
        tv_question.text = question.question
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        iv_image.setImageResource(question.image)
        val tv_optionone = findViewById<TextView>(R.id.tv_optionone)
        tv_optionone.text = question.optionOne
        val tv_optiontwo = findViewById<TextView>(R.id.tv_optiontwo)
        tv_optiontwo.text = question.optionTwo
        val tv_optionthree = findViewById<TextView>(R.id.tv_optionthree)
        tv_optionthree.text = question.optionThree
        val tv_optionfour = findViewById<TextView>(R.id.tv_optionfour)
        tv_optionfour.text = question.optionFour

    }
    private fun defaultOptionsView(){
        val tv_optionone = findViewById<TextView>(R.id.tv_optionone)
        val tv_optiontwo = findViewById<TextView>(R.id.tv_optiontwo)
        val tv_optionthree = findViewById<TextView>(R.id.tv_optionthree)
        val tv_optionfour = findViewById<TextView>(R.id.tv_optionfour)
        val tv_laugh = findViewById<TextView>(R.id.tv_laugh)
        tv_laugh.text = ":|"
        val options = ArrayList<TextView>()
        options.add(0, tv_optionone)
        options.add(1, tv_optiontwo)
        options.add(2, tv_optionthree)
        options.add(3, tv_optionfour)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        val tv_optionone = findViewById<TextView>(R.id.tv_optionone)
        val tv_optiontwo = findViewById<TextView>(R.id.tv_optiontwo)
        val tv_optionthree = findViewById<TextView>(R.id.tv_optionthree)
        val tv_optionfour = findViewById<TextView>(R.id.tv_optionfour)
        val btn_select = findViewById<Button>(R.id.btn_select)

        when(v?.id) {
            R.id.tv_optionone -> {
                selectedOptionView(tv_optionone, 1)
            }
            R.id.tv_optiontwo -> {
                selectedOptionView(tv_optiontwo, 2)
            }
            R.id.tv_optionthree -> {
                selectedOptionView(tv_optionthree, 3)
            }
            R.id.tv_optionfour -> {
                selectedOptionView(tv_optionfour, 4)
            }

            R.id.btn_select ->{
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                          val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val tv_laugh = findViewById<TextView>(R.id.tv_laugh)
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        tv_laugh.text = ":("
                    }else{
                        tv_laugh.text = ":)"
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_bordeer_bg)
                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btn_select.text = "Natijani ko'rish"
                    }else{
                        btn_select.text = "Keyingi savolga o'tish"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
   private fun answerView(answer: Int, drawableView: Int) {
        val tv_optionone = findViewById<TextView>(R.id.tv_optionone)
        val tv_optiontwo = findViewById<TextView>(R.id.tv_optiontwo)
        val tv_optionthree = findViewById<TextView>(R.id.tv_optionthree)
        val tv_optionfour = findViewById<TextView>(R.id.tv_optionfour)
        when(answer){
            1 ->{
                tv_optionone.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            2 ->{
                    tv_optiontwo.background = ContextCompat.getDrawable(
                            this, drawableView
                    )
                }
            3 ->{
                    tv_optionthree.background = ContextCompat.getDrawable(
                            this, drawableView
                    )
                }
            4 ->{
                    tv_optionfour.background = ContextCompat.getDrawable(
                            this, drawableView
                    )
                }
            }
        }

    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNum: Int){
        defaultOptionsView()
        val tv_laugh = findViewById<TextView>(R.id.tv_laugh)
        if(mSelectedOptionPosition == 0) {
            mSelectedOptionPosition = selectedOptionNum
            tv.setTextColor(Color.parseColor("#163A23"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this,
                    R.drawable.selected_option_border_bg)
        }
        tv_laugh.text = "8)"
    }
}