package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Questions

object Constants
{
    const val USER_NAME="user_name"
    const val TOTAL_QUESTIONS="total questions"
    const val SCORE="correct_answers"

    fun getQuestions(): MutableList<Questions>
    {
        val questions= mutableListOf<Questions>()
        val quest1=Questions(
            1,"What country does this flag belong ?",
            R.drawable.italy_flag,"Italy","India","Iran","Ireland",
            1)
        questions.add(quest1)

        val quest2=Questions(
            1,"What country does this flag belong ?",
            R.drawable.argentina_flag,"Italy","Haiti","Brazil","Argentia",
            4)
        questions.add(quest2)

        val quest3=Questions(
            1,"What country does this flag belong ?",
            R.drawable.brazil_flag,"Italy","Brazil","Romania","Spain",
            2)
        questions.add(quest3)

        val quest4=Questions(
            1,"What country does this flag belong ?",
            R.drawable.finland_flag,"Finland","USA","Australia","New Zealand",
            1)
        questions.add(quest4)


        val quest5=Questions(
            1,"What country does this flag belong ?",
            R.drawable.france_flag,"Italy","Germany","France","None of the above",
            3)
        questions.add(quest5)

        val quest6=Questions(
            1,"What country does this flag belong ?",
            R.drawable.germany_flag,"Germany","India","Nigeria","France",
            1)
        questions.add(quest6)

        val quest7=Questions(
            1,"What country does this flag belong ?",
            R.drawable.haiti_flag,"Italy","Germany","haiti","Ireland",
            3)
        questions.add(quest7)

        val quest8=Questions(
            1,"What country does this flag belong ?",
            R.drawable.india_flag,"Italy","India","Iran","Ireland",
            2)
        questions.add(quest8)

        val quest9=Questions(
            1,"What country does this flag belong ?",
            R.drawable.nigeria_flag,"Uganda","Nigeria","Pakistan","Afghanistan",
            3)
        questions.add(quest9)

        val quest10=Questions(
            1,"What country does this flag belong ?",
            R.drawable.romania_flag,"Italy","Germany","Spain","Romania",
            4)
        questions.add(quest10)

        return questions

    }
}