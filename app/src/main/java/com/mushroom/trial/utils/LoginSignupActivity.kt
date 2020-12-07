package com.mushroom.trial.utils

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.mushroom.trial.Adapters.deepager
import com.mushroom.trial.R
import com.mushroom.trial.questionaires.Constants
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginSignupActivity : AppCompatActivity() {

    private lateinit var deePager: ViewPager
    private lateinit var mdeepager: deepager
    private lateinit var anims : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        deePager = findViewById(R.id.deePager)
        mdeepager = deepager(supportFragmentManager)
        deePager.adapter = mdeepager
        deePager.offscreenPageLimit = 2

         anims = AnimationUtils.loadAnimation(this,R.anim.stay)
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
        log.setTextColor(Color.parseColor("#0ed145"))

        val  goo = findViewById<ImageButton>(R.id.goo)

        goo.setOnClickListener {




                val intent = Intent(this, landPage::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // START
                intent.putExtra(Constants.USER_NAME, email.text.toString())
                // END
                startActivity(intent)
                finish()
            }



    }


    private fun changingTabs(position: Int) {
        if (position == 0) {
            log.setTextColor(Color.parseColor("#0ed145"))
            sig.setTextColor(Color.parseColor("#9ACCCCCC"))

        }
        if (position == 1) {
            log.setTextColor(Color.parseColor("#9ACCCCCC"))
            sig.setTextColor(Color.parseColor("#0ed145"))

        }
    }
}