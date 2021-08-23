package com.mushroom.pronoun.questionaires


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.mushroom.pronoun.R
import com.mushroom.pronoun.database.DatabaseHelper
import com.mushroom.pronoun.model.Constants
import com.mushroom.pronoun.model.Question2
import com.mushroom.pronoun.model.SharedPreference
import com.mushroom.pronoun.view.ResultScreen
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_p_q.*
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule


class PQActivity8 : AppCompatActivity(), View.OnClickListener {
    var mtimes = 0
    lateinit var databaseHelper: DatabaseHelper

    //get repo

    //check status to update  or save score


    val MIt: String = "SUbMIT"
    private var mSelectedOptionPosition = 0
    private var rightAnswers = 1
    private var mak: Any? = null
    private var state = 1

    //lets create an ArrayList of our Question data class
    private var arr = ArrayList<Question2>()
    var qPosition = 1 //helps us determine question position and some other things too

    override fun onCreate(savedInstanceState: Bundle?) {
        //init shared preferences

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_q)
        databaseHelper = DatabaseHelper(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#FBFBFB")
            window.navigationBarColor = Color.parseColor("#FBFBFB")
        }
        // TODO (STEP 4: Get the NAME from intent and assign it the variable.)
        // START
        //mUserName = landPage().landDept.toString()
        //lets initialize those functions here
        loadJson()
        setQ()
        butMIt.setOnClickListener(this)
        rB1.setOnClickListener(this)
        rB2.setOnClickListener(this)
        rB3.setOnClickListener(this)
        rB4.setOnClickListener(this)
    }
    //lets create a function that binds our views to dataclass

    fun setQ() {
        lt1.speed = -50f
        lt1.playAnimation()
        lt2.speed = -50f
        lt2.playAnimation()
        lt3.speed = -50f
        lt3.playAnimation()
        lt4.speed = -50f
        lt4.playAnimation()
        rB2.setTextColor(Color.parseColor("#C3C3C3"))
        rB3.setTextColor(Color.parseColor("#C3C3C3"))
        rB1.setTextColor(Color.parseColor("#C3C3C3"))
        rB4.setTextColor(Color.parseColor("#C3C3C3"))
        rB1.isChecked = false
        rB2.isChecked = false
        rB3.isChecked = false
        rB4.isChecked = false
        if (qPosition == arr.size) {
            butMIt.text = MIt
        } else {
            butMIt.text = "next"
        }
        val questionq = arr[qPosition - 1]
        progressBar.max = arr.size // the size of our json in arraylist
        progressBar.progress = qPosition
        quesDis.text = "Question $qPosition/${arr.size}"
        solve.text = questionq.mainQuestion
        rB1.text = questionq.Option1
        rB2.text = questionq.Option2
        rB3.text = questionq.Option3
        rB4.text = questionq.Option4
        textView16.text = mak.toString()
    }
    //function to load json

    fun loadJson() {
        val json: String?
        //try ,catch used to avoid exception issues
        try {
            val inputStream: File? =
                this.getExternalFilesDir("Pronoun/Data/h.json")  //here is where we put the json file
            json = inputStream!!.bufferedReader().use { it.readText() }
            val jsonArr = JSONObject(json) //we set json to array
            mak = jsonArr.getString("mark")
            val smooth = jsonArr.getJSONArray("simon")
            //now we iterate array
            for (i in 0 until smooth.length()) {
                val jsonObj = smooth.getJSONObject(i)
                //now we tie variables to content of our json
                val quest = jsonObj.getString("question")
                val one = jsonObj.getString("answer1")
                val two = jsonObj.getString("answer2")
                val three = jsonObj.getString("answer3")
                val four = jsonObj.getString("answer4")
                val cor = jsonObj.getInt("correct")
                //now lets add the json contents stored in these variables into our data class

                arr.add(Question2(quest, one, two, three, four, cor))

            }
        } catch (e: IOException) {

        }

    }

    private fun defaultOptionsView() {
        val choices = ArrayList<RadioButton>()
        choices.add(0, rB1)
        choices.add(1, rB2)
        choices.add(2, rB3)
        choices.add(3, rB4)

        for (dee in choices) {

            dee.setTextColor(Color.parseColor("#C3C3C3"))
            dee.typeface = Typeface.DEFAULT


        }
    }

    private fun selectedOptionView(rad: RadioButton, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        rad.setTextColor(
            Color.parseColor("#2c9d65")
        )

        rad.setTypeface(rad.typeface, Typeface.NORMAL)


    }

    override fun onClick(v: View?) {
        //lets set button
        when (v?.id) {


            R.id.rB1 -> {
                lt3.speed = -50f
                lt3.playAnimation()
                lt1.speed = 2f
                lt1.playAnimation()
                lt2.speed = -50f
                lt2.playAnimation()
                lt4.speed = -50f
                lt4.playAnimation()




                selectedOptionView(rB1, 1)
            }

            R.id.rB2 -> {
                lt3.speed = -50f
                lt3.playAnimation()
                lt1.speed = -50f
                lt1.playAnimation()
                lt2.speed = 2f
                lt2.playAnimation()
                lt4.speed = -50f
                lt4.playAnimation()



                selectedOptionView(rB2, 2)
            }

            R.id.rB3 -> {
                lt3.speed = 2f
                lt3.playAnimation()
                lt1.speed = -50f
                lt1.playAnimation()
                lt2.speed = -50f
                lt2.playAnimation()
                lt4.speed = -50f
                lt4.playAnimation()


                selectedOptionView(rB3, 3)
            }

            R.id.rB4 -> {
                lt4.speed = 2f
                lt4.playAnimation()
                lt2.speed = -50f
                lt2.playAnimation()
                lt3.speed = -50f
                lt3.playAnimation()
                lt1.speed = -50f
                lt1.playAnimation()


                selectedOptionView(rB4, 4)
            }

            R.id.butMIt -> {
//                val userDetailsRepository = ViewModelProvider(this).get(LoginViewModel::class.java)

                when {
                    rB1.isChecked || rB2.isChecked || rB3.isChecked || rB4.isChecked -> {
                        qPosition++
                        ltview.playAnimation()
                        when {

                            qPosition <= arr.size -> {

                                setQ()
                            }
                            else -> {
                                //adds()
                                // TODO (STEP 5: Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                                // START
                                val intent =
                                    Intent(this, ResultScreen::class.java)
                                //intent.putExtra(Constants.USER_NAME, mUserName)
                                mtimes++


                                intent.putExtra(Constants.CORRECT_ANSWERS, rightAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTIONS, arr.size)
                                val flag: Boolean

                                val applicationpreferences = PreferenceManager
                                    .getDefaultSharedPreferences(this)

                                val editor = applicationpreferences.edit()

                                flag = applicationpreferences.getBoolean("flag", false)

                                if (flag) {
///second time activity
                                    update(1, rightAnswers.toString(), arr.size.toString())
                                } else {
//first time
                                    yes(rightAnswers.toString(), arr.size.toString())
                                    editor.putBoolean("flag", true)
                                    editor.apply()
                                }
                                Timer().schedule(2000) {

                                    // yes(rightAnswers.toString(), arr.size.toString(), mtimes,state)
                                    startActivity(intent)
                                    finish()
                                }
                                // END
                            }
                        }
                        val question = arr[qPosition - 2]
                        // This is to check if the answer is wrong
                        if (question.Correct != mSelectedOptionPosition) {
                            Alerter.create(this)
                                .setBackgroundColorRes(R.color.fail)
                                .setText("sorry you're wrong")
                                .setTitle("Oh No")
                                .show()
                            //Toast.makeText(this,"wrong",Toast.LENGTH_SHORT).show()
                            //answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        } else {
                            rightAnswers++
                            lor.visibility = View.VISIBLE
                            lor.speed = 0.9f
                            lor.playAnimation()
                            Alerter.create(this)
                                .setBackgroundColorRes(R.color.colorGold)
                                .setText("You got this correct")
                                .setEnterAnimation(R.anim.bottomslide2)
                                .setTitle("Way to go")
                                .show()
                            //Toast.makeText(this,"got it right",Toast.LENGTH_SHORT).show()

                        }

                    }
                    else -> {
                        vibrate()
                    }
                }


            }
        }
    }


    fun vibrate() {
        val vibe = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT > 26) {
            vibe.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibe.cancel()
        }
    }

    fun update(state: Int, score: String, total: String) {
        val thread = Thread {

            databaseHelper.updateData8(state, score, total)
            Log.i("Updated", "Data saved $score")
        }
        thread.start()
    }

    fun yes(score: String, total: String) {
        val thread = Thread {

            databaseHelper.insertData8(score, total)
            Log.i("Saved", "Data saved $score")
        }
        thread.start()
    }

}


