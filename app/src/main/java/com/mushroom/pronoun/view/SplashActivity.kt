package com.mushroom.pronoun.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.mushroom.pronoun.R
import com.mushroom.pronoun.model.SharedPreference
import kotlinx.android.synthetic.main.activity_main.*


class SplashActivity : AppCompatActivity() {


    private lateinit var anim: Animation

    lateinit var sharedPreference: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreference = SharedPreference(this)
        run {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            window.statusBarColor = Color.parseColor("#12526474")
        }

        anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        prn.startAnimation(anim)



//handler that controls firstTime only activity launch
        val handler = Handler()
        handler.postDelayed({

//this function takes the numbers from shared prefrences and saves them
            when (sharedPreference.getValueInt("num")) {
                0 -> {
                    startActivity(Intent(this, OnboardActivity::class.java))
                    finish()
                }
                1 -> {
                    startActivity(Intent(this, LoginSignupActivity::class.java))
                    finish()
                }
                2 -> {
                    startActivity(Intent(this, landPage::class.java))
                    finish()
                }

//end
            }

        }, 1500)
    }


}

