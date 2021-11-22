package com.mushroom.pronoun.view

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.mushroom.pronoun.Adapters.PagerAdapter
import com.mushroom.pronoun.R
import com.mushroom.pronoun.model.SharedPreference
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_landpage.*


class OnboardActivity : AppCompatActivity() {
    val myPreferences = "mypref"

    lateinit var  sharedPreference: SharedPreference
    private lateinit var mViewPager : ViewPager
    private lateinit var sip: ImageView
    private lateinit var fab : ImageButton
    private lateinit var sip2: ImageView
    private lateinit var sip3: ImageView
    private lateinit var mPagerAdapter: PagerAdapter
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_onboard)
        sharedPreference= SharedPreference(this)
        sharedPreference.save("num",0)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#FFFFFF")
        }


        //inits
        fab= findViewById(R.id.fab)
        sip= findViewById(R.id.sip)
        sip2= findViewById(R.id.sip2)
        sip3= findViewById(R.id.sip3)
        mViewPager= findViewById(R.id.mviewPager)
        //footer= findViewById(R.id.linda)
        mPagerAdapter = PagerAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerAdapter
        mViewPager.offscreenPageLimit = 3

        // add page listener
        mViewPager.apply {
arrowScroll(3)
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    Dots(position)
                }

            })
        }
        //default tab
        mViewPager.currentItem = 0
        sip.setImageResource(R.drawable.ic_baseline_brightness_yellow)
        //footer.setBackgroundColor(Color.parseColor("#FF1493"))

        fab.setOnClickListener {
           isOnline(this)
        }
    }

    private fun Dots(position: Int) {
        if (position == 0){
            sip.setImageResource(R.drawable.ic_baseline_brightness_yellow)
            sip2.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            sip3.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            //footer.setBackgroundColor(Color.parseColor("#FF1493"))
            fab.visibility = View.VISIBLE
        }
        if (position == 1){
            sip.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            sip2.setImageResource(R.drawable.ic_baseline_brightness_yellow)
            sip3.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            //footer.setBackgroundColor(Color.parseColor("#AA1AD1"))
            fab.visibility = View.VISIBLE
        }
        if (position == 2){
            sip.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            sip2.setImageResource(R.drawable.ic_baseline_brightness_1_24)
            sip3.setImageResource(R.drawable.ic_baseline_brightness_yellow)
            //footer.setBackgroundColor(Color.parseColor("#FF1493"))
            fab.visibility = View.VISIBLE
        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    sharedPreference.save("num",1)

                    val intent = Intent(this, LoginSignupActivity::class.java)
                    startActivity(intent)
                    finish()

                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    val intent = Intent(this, LoginSignupActivity::class.java)
                    startActivity(intent)
                    finish()
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        Alerter.create(this)
            .setBackgroundColorRes(R.color.colorGold)
            .setText("Pronoun need network to run for the first time")
            .setIcon(R.drawable.ic_baseline_email_24)
            .setTitle("Turn on Data")
            .showIcon(true)
            .show()
        return false
    }




}