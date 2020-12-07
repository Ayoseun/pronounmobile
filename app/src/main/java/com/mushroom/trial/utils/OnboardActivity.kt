package com.mushroom.trial.utils

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.viewpager.widget.ViewPager
//import com.mushroom.trial.Adapters.deepagerOnboarding
import com.mushroom.trial.R
import kotlinx.android.synthetic.main.activity_main2.*

class OnboardActivity : AppCompatActivity() {

    private lateinit var deePager2: ViewPager
    //private lateinit var deepagerOnboarding: deepagerOnboarding
    private lateinit var anim : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)


        deePager2 = findViewById(R.id.deePager2)
        //deepagerOnboarding = deepagerOnboarding(supportFragmentManager)
        //deePager2.adapter = deepagerOnboarding
        //deePager2.offscreenPageLimit = 2

        anim = AnimationUtils.loadAnimation(this,R.anim.stay)
        deePager2.startAnimation(anim)

        deePager2.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                changingEdu(position)
            }

        })
        //default tab
        deePager2.currentItem = 0

    }


    private fun changingEdu(position: Int) {
        if (position == 0) {
            log.setTextColor(Color.parseColor("#0ed145"))
            sig.setTextColor(Color.parseColor("#9ACCCCCC"))

        }
        if (position == 1) {
            log.setTextColor(Color.parseColor("#9ACCCCCC"))
            sig.setTextColor(Color.parseColor("#0ed145"))

        }
        if (position == 2) {
            log.setTextColor(Color.parseColor("#9ACCCCCC"))
            sig.setTextColor(Color.parseColor("#0ed145"))

        }
    }


}