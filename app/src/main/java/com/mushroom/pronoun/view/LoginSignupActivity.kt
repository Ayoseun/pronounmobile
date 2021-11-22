package com.mushroom.pronoun.view

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.mushroom.pronoun.Adapters.deepager
import com.mushroom.pronoun.R
import kotlinx.android.synthetic.main.activity_main2.*


class LoginSignupActivity : AppCompatActivity() {

    private lateinit var deePager: ViewPager
    private lateinit var mdeepager: deepager
    private lateinit var anims : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#2c9d65")
        }

        deePager = findViewById(R.id.deePager)
        mdeepager = deepager(supportFragmentManager)
        deePager.adapter = mdeepager
        deePager.offscreenPageLimit = 2

         anims = AnimationUtils.loadAnimation(this, R.anim.stay)
        deePager.startAnimation(anims)

        deePager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                changingTabs(position)
            }

        })
        //default tab
        deePager.currentItem = 0
        log.setTextColor(Color.parseColor("#00A91D"))




    }

    fun loaddeer(fragment: androidx.fragment.app.Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.change, fragment)
        fragmentTransaction.commit()
    }
    private fun changingTabs(position: Int) {
        if (position == 0) {
            log.setTextColor(Color.parseColor("#00A91D"))
            sec.setBackgroundResource(R.color.colornewAccent)
            sec2.setBackgroundResource(R.color.tint)
            dp3.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            dp.setImageResource(R.drawable.ic_baseline_brightness_yellow)
            log.textSize = 15f
            sig.textSize = 10f
            sig.setTextColor(Color.parseColor("#9ACCCCCC"))

        }
        if (position == 1) {
            log.setTextColor(Color.parseColor("#9ACCCCCC"))
            sec2.setBackgroundResource(R.color.colornewAccent)
            sec.setBackgroundResource(R.color.tint)
            sig.textSize = 15f
            log.textSize = 10f
            sig.setTextColor(Color.parseColor("#00A91D"))
            dp.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            dp3.setImageResource(R.drawable.ic_baseline_brightness_yellow)
        }
    }
}