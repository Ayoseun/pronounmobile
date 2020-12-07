package com.mushroom.trial.questionaires

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mushroom.trial.R
import com.mushroom.trial.utils.landPage
import kotlinx.android.synthetic.main.activity_result_screen.*

class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)


        // TODO (STEP 6: Hide the status bar and get the details from intent and set it to the UI. And also add a click event to the finish button.)
        // START
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val butf = findViewById<Button>(R.id.butf)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        textView2.text = "Your Score is $correctAnswers out of $totalQuestions."

        butf.setOnClickListener {
            startActivity(Intent(this, landPage::class.java))
        }
        // END
    }
}