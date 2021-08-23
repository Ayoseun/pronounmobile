package com.mushroom.pronoun.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.mushroom.pronoun.R

class SettingsActivity : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this, landPage::class.java))
        finish()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val sum = myActivitiesFragment()
        loaddeer(sum)
        run {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#F3F3F3")
        }
    }



    fun loaddeer(fragment: androidx.fragment.app.Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.tinn, fragment)
        fragmentTransaction.commit()
    }
}