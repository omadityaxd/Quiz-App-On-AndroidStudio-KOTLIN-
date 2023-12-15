package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.model.Questions
import com.example.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity() ,View.OnClickListener{
    private lateinit var progressBar:ProgressBar
    private lateinit var textViewProgress:TextView
    private lateinit var textViewQuestion:TextView
    private lateinit var flagImage:ImageView

    private lateinit var textviewOption1:TextView
    private lateinit var textviewOption2:TextView
    private lateinit var textviewOption3:TextView
    private lateinit var textviewOption4:TextView

    private lateinit var checkButton:Button

    private var questionCounter=0
    private lateinit var questionsList:MutableList<Questions>

    private var selectedAnswers=0

    private lateinit var currentQuestion:Questions
    private var answered=false

    private lateinit var name:String

    private  var score=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)



        progressBar=findViewById(R.id.progressBar)
        textViewProgress=findViewById(R.id.progressBar_textView)
        textViewQuestion=findViewById(R.id.question_text_View)
        flagImage=findViewById(R.id.image_flag)

        textviewOption1=findViewById(R.id.textView_optionOne)
        textviewOption2=findViewById(R.id.textView_optionTwo)
        textviewOption3=findViewById(R.id.textView_optionThree)
        textviewOption4=findViewById(R.id.textView_optionFour)

        textviewOption1.setOnClickListener(this)
        textviewOption2.setOnClickListener(this)
        textviewOption3.setOnClickListener(this)
        textviewOption4.setOnClickListener(this)

        checkButton=findViewById(R.id.button_check)
        checkButton.setOnClickListener(this)
        questionsList = Constants.getQuestions()
        Log.d("QuestionSize","${questionsList.size}")
        showNextQuestion()

        if(intent.hasExtra(Constants.USER_NAME))
        {
            name= intent.getStringExtra(Constants.USER_NAME)!!
        }
    }

    private fun showNextQuestion()
    {
        if(questionCounter<questionsList.size)
        {
            checkButton.text="CHECK"
            currentQuestion=questionsList[questionCounter]
            resetOptions()
            val question=questionsList[questionCounter]
            flagImage.setImageResource(question.image)
            progressBar.progress=questionCounter
            textViewProgress.text="${questionCounter+1}/${progressBar.max}"
            textViewQuestion.text=question.question
            textviewOption1.text=question.optionOne
            textviewOption2.text=question.optionTwo
            textviewOption3.text=question.optionThree
            textviewOption4.text=question.optionFour
        }
        else
        {
            checkButton.text="FINISH"

            Intent(this,resultActivity::class.java).also{
                it.putExtra(Constants.USER_NAME,name)
                it.putExtra(Constants.SCORE,score)
                it.putExtra(Constants.TOTAL_QUESTIONS,questionsList.size)

                startActivity(it)
            }
        }
        questionCounter++
        answered=false
    }

    private fun resetOptions()
    {
        val options= mutableListOf<TextView>()
        options.add(textviewOption1)
        options.add(textviewOption2)
        options.add(textviewOption3)
        options.add(textviewOption4)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,
            R.drawable.deafault_border_bg)
        }
    }

    private fun selectOption(textView: TextView,selectOptionNumber:Int)
    {
        resetOptions()
        selectedAnswers=selectOptionNumber
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.textView_optionOne->
            {
                selectOption(textviewOption1,1)
            }
            R.id.textView_optionTwo->
            {
                selectOption(textviewOption2,2)
            }
            R.id.textView_optionThree->
            {
                selectOption(textviewOption3,3)
            }
            R.id.textView_optionFour->
            {
                selectOption(textviewOption4,4)
            }
            R.id.button_check->
            {
                if(!answered)
                {
                    checkAnswer()
                }
                else
                {
                    showNextQuestion()
                }
                selectedAnswers=0
            }
        }
    }

    private fun checkAnswer()
    {
        answered=true

        if(selectedAnswers==currentQuestion.correctAnswer)
        {
            score++
            when(selectedAnswers)
            {
                1->
                {
                    textviewOption1.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
                }
                2->
                {
                    textviewOption2.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
                }
                3->
                {
                    textviewOption3.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
                }
                4->
                {
                    textviewOption4.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
                }
            }
        }
        else
        {
            when(selectedAnswers)
            {
                1->
                {
                    textviewOption1.background=ContextCompat.getDrawable(this,R.drawable.wrongoption_border_bg)
                }
                2->
                {
                    textviewOption2.background=ContextCompat.getDrawable(this,R.drawable.wrongoption_border_bg)
                }
                3->
                {
                    textviewOption3.background=ContextCompat.getDrawable(this,R.drawable.wrongoption_border_bg)
                }
                4->
                {
                    textviewOption4.background=ContextCompat.getDrawable(this,R.drawable.wrongoption_border_bg)
                }
            }
        }
        checkButton.text="NEXT"
        showSolution()
    }

    private fun showSolution()
    {
        selectedAnswers=currentQuestion.correctAnswer

        when(selectedAnswers)
        {
            1->
            {
                textviewOption1.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
            }
            2->
            {
                textviewOption2.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
            }
            3->
            {
                textviewOption3.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
            }
            4->
            {
                textviewOption4.background=ContextCompat.getDrawable(this,R.drawable.correctoption_border_bg)
            }
        }
    }
}