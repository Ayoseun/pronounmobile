package com.mushroom.trial.questionaires

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.animation.Animation
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.mushroom.trial.R
import kotlinx.android.synthetic.main.activity_p_q.*

class PQActivity : AppCompatActivity(),View.OnClickListener {


    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var listQuestion: ArrayList<Question>? = null
    var checkers: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private lateinit var anime: Animation
    private var rightAnswers: Int = 0

    // TODO (STEP 3: Create a variable for getting the name from intent.)
    // START
    private var mUserName: String? = null
    // END

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_q)

        // TODO (STEP 4: Get the NAME from intent and assign it the variable.)
        // START
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        // END

        listQuestion = Eco231.Eco231Q()

        setQuestion()

        rB1.setOnClickListener(this)
        rB2.setOnClickListener(this)
        rB3.setOnClickListener(this)
        rB4.setOnClickListener(this)
        butMIt.setOnClickListener(this)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.rB1 -> {



                selectedOptionView(rB1, 1)
            }

            R.id.rB2 -> {


                selectedOptionView(rB2, 2)
            }

            R.id.rB3 -> {


                selectedOptionView(rB3, 3)
            }

            R.id.rB4 -> {



                selectedOptionView(rB4, 4)
            }

            R.id.butMIt -> {

                if (mSelectedOptionPosition == 0 && rB1.isChecked || rB2.isChecked || rB3.isChecked || rB4.isChecked) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= listQuestion!!.size -> {

                            setQuestion()
                        }
                        else -> {

                            // TODO (STEP 5: Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                            // START
                            val intent =
                                Intent(this, ResultScreen::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, rightAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, listQuestion!!.size)
                            startActivity(intent)
                            finish()
                            // END
                        }
                    }
                } else {
                    val question = listQuestion?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.Correct == mSelectedOptionPosition) {
                        rightAnswers++
                    }

                    // This is for correct answer


                    if (mCurrentPosition == listQuestion!!.size) {
                        butMIt.text = "FINISH"
                    } else {
                        butMIt.text = "NEXT"

                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setQuestion() {

        val question =
            listQuestion!![mCurrentPosition - 1] // Getting the question from the list with the help of current position.

        defaultOptionsView()


        if (mCurrentPosition == listQuestion!!.size) {

            butMIt.text = "SUbMIT"
        } else {
            butMIt.text = "Confirm"
        }

        progressBar.progress = mCurrentPosition
        progressBar.max = listQuestion!!.size
        quesDis.text = "Question " + "$mCurrentPosition" + "/" + "${listQuestion!!.size}"
        solve.text = question.mainQuestion

        rB1.text = question.Option1
        rB2.text = question.Option2
        rB3.text = question.Option3
        rB4.text = question.Option4
    }

    /**
     * A function to set the view of selected option view.
     */

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun selectedOptionView(rad: RadioButton, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        rad.setTextColor(
            Color.parseColor("#2c9d65")
        )
        rad.buttonTintList = ColorStateList.valueOf(Color.parseColor("#2c9d65"))
        rad.setTypeface(rad.typeface, Typeface.NORMAL)


    }

    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun defaultOptionsView() {
        val choices = ArrayList<RadioButton>()
        choices.add(0, rB1)
        choices.add(1, rB2)
        choices.add(2, rB3)
        choices.add(3, rB4)

        for (dee in choices) {
            dee.setTextColor(Color.parseColor("#C3C3C3"))
            dee.typeface = Typeface.DEFAULT
            dee.isChecked = false


        }


    }
}