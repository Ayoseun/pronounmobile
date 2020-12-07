package com.mushroom.trial.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import com.mushroom.trial.R
import kotlinx.android.synthetic.main.activity_main.*



class SplashActivity : AppCompatActivity() {
     private lateinit var anim : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        anim = AnimationUtils.loadAnimation(this,R.anim.bounce)
        prn.startAnimation(anim)
  val  prn = findViewById<ImageButton>(R.id.prn)

       // prn.setOnClickListener {
            //startActivity(Intent(this , LoginSignupActivity::class.java)) }
       val  handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, LoginSignupActivity::class.java)
            startActivity(intent)
            finish()

        }, 3000)
    }

}