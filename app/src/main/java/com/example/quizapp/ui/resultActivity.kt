package com.example.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.MainActivity
import com.example.quizapp.R

class resultActivity : AppCompatActivity() {
    private lateinit var textviewName:TextView
    private lateinit var textviewScore:TextView
    private lateinit var finishButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textviewName=findViewById(R.id.textview_name)
        textviewScore=findViewById(R.id.textview_score)
        finishButton=findViewById(R.id.finish_button)
        val totalQuestions=intent.getIntExtra(com.example.quizapp.utils.Constants.TOTAL_QUESTIONS,0)
        val score=intent.getIntExtra(com.example.quizapp.utils.Constants.SCORE,0)
        val name=intent.getStringExtra(com.example.quizapp.utils.Constants.USER_NAME)

        textviewScore.text="Your score is $score out of 10"
        textviewName.text=name

        finishButton.setOnClickListener {

            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}