package com.mushroom.pronoun.view

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.mushroom.pronoun.R
import kotlinx.android.synthetic.main.activity_landpage.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class landPage : AppCompatActivity(), View.OnClickListener {
    lateinit var userDao: Any

    var count: String = ""


    var buttonOn = true

    val doo = SplashActivity().isDestroyed
    private lateinit var anim: Animation
    lateinit var sharedPreferences: SharedPreferences
    val myPreferences = "mypref"
    val nameKey = "namekey"
    val nameKey2 = "namekey2"
    val nameKey3 = "namekey3"
    val nameKey4 = "namekey4"
    val nameKey5 = "namekey5"

    var stay = 0
    private val MY_PERMISSION_REQUEST = 100

    override fun onStart() {
        super.onStart()
        grantedPermission()
        savePreference()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_landpage)



        //  imageReference = FirebaseStorage.getInstance().reference.child("Pronoun/Science/studykit2021.png")
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        savePreference()
        anim = AnimationUtils.loadAnimation(this, R.anim.bottomslide2)
        //val userDao = com.mushroom.pronoun.db.AppDatabase.getDatabase(applicationContext)!!.userDao()
        locks.setOnClickListener {


            buttonOn = when (buttonOn) {


                true -> {
                    locks.startAnimation(anim)
                    locks.setImageResource(R.drawable.unlock)
                    false
                }
                false -> {
                    locks.startAnimation(anim)
                    locks.setImageResource(R.drawable.lock)
                    true
                }
            }

        }


        run {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#12526474")
        }

        open.setOnClickListener(this)
        open2.setOnClickListener(this)
        open3.setOnClickListener(this)
        open4.setOnClickListener(this)


        val sum = LandSummaryFragment()
        loaddeer(sum)


    }

    override fun onResume() {
        super.onResume()
        val sum = LandSummaryFragment()
        loaddeer(sum)

        // resume.visibility = View.VISIBLE
        topGuy.text = "Semester Mode"
        pqBtn.setImageResource(R.drawable.pqicondark2021)
        cloud.setImageResource(R.drawable.ic_baseline_show_chart_24)
        setting.setImageResource(R.drawable.setblack)

        career.setImageResource(R.drawable.lampblack)
        textView7.setTextColor(Color.parseColor("#2c9d65"));
        textView6.setTextColor(Color.parseColor("#526474"));
        textView5.setTextColor(Color.parseColor("#526474"));
        textView8.setTextColor(Color.parseColor("#526474"));
    }


    override fun onBackPressed() {
        when (stay) {
            0 -> {
                Toast.makeText(this, "Tap again to exit", Toast.LENGTH_SHORT).show()
                stay++
            }
            1 -> {
                super.onBackPressed()
                closeContextMenu()
                onDestroy()
                finish()

                doo
            }
        }


        //super.onBackPressed()
        //closeContextMenu()
        //onDestroy()

        //doo
    }

    fun loaddeer(fragment: androidx.fragment.app.Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.line, fragment)
        fragmentTransaction.commit()
    }


    private fun grantedPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(READ_EXTERNAL_STORAGE),
                MY_PERMISSION_REQUEST
            )
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    READ_EXTERNAL_STORAGE
                )
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(READ_EXTERNAL_STORAGE),
                    MY_PERMISSION_REQUEST
                )
            } else {
                if (ContextCompat.checkSelfPermission(
                        this,
                       READ_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    val snackbar = Snackbar.make(
                        activityLand,
                        "Provide the Storage Permission",
                        Snackbar.LENGTH_LONG
                    )
                    snackbar.show()
                }
            }
        } else {

        }
    }

    /**
     * Checking if the permission is granted or not
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSION_REQUEST -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        READ_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show()

                } else {
                    val snackBar = Snackbar.make(
                        activityLand,
                        "Provide the Storage Permission",
                        Snackbar.LENGTH_LONG
                    )
                    snackBar.show()
                    finish()
                }
            }
        }
    }




    fun savePreference() {
        CoroutineScope(IO).launch {
            withContext(Main) {

                if (sharedPreferences.contains(nameKey)) {
                    landname.text = sharedPreferences.getString(nameKey, "")

                    if (sharedPreferences.contains(nameKey2)) {
                        landSurname.text = sharedPreferences.getString(nameKey2, "")

                        if (sharedPreferences.contains(nameKey3)) {
                            cLevel.text = sharedPreferences.getString(nameKey3, "")

                            if (sharedPreferences.contains(nameKey4)) {
                                landDept.text = sharedPreferences.getString(nameKey4, "")
                                if (sharedPreferences.contains(nameKey5)) {
                                    semesterTxt.text = sharedPreferences.getString(nameKey5, "")
                                }
                            }
                        }
                    }
                } else {
                    val intent = intent

                    val fName = intent.getStringExtra("firstName")
                    val lName = intent.getStringExtra("lastName")
                    val lvlvl = intent.getStringExtra("level");
                    val semester = intent.getStringExtra("semester");
                    val courS = intent.getStringExtra("course");

                    //val sp = PreferenceManager.getDefaultSharedPreferences(this)
                    val mEditor = sharedPreferences.edit()
                    mEditor.putString(nameKey, fName.toString())
                    mEditor.putString(nameKey2, lName.toString())
                    mEditor.putString(nameKey3, lvlvl.toString())
                    mEditor.putString(nameKey5, semester.toString())
                    mEditor.putString(nameKey4, courS.toString())


                    mEditor.apply()

                }
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {


            R.id.open -> {
                val sum = LandSummaryFragment()
                loaddeer(sum)
                // resume.visibility = View.INVISIBLE
                topGuy.text = "Semester Mode"
                pqBtn.setImageResource(R.drawable.pqicondark2021)
                cloud.setImageResource(R.drawable.ic_baseline_show_chart_24)
                setting.setImageResource(R.drawable.setblack)
                career.setImageResource(R.drawable.lampblack)
                textView7.setTextColor(Color.parseColor("#2c9d65"));
                textView6.setTextColor(Color.parseColor("#526474"));
                textView5.setTextColor(Color.parseColor("#526474"));
                textView8.setTextColor(Color.parseColor("#526474"));


            }

            R.id.open2 -> {
                pqBtn.setImageResource(R.drawable.pqicon2021)
                cloud.setImageResource(R.drawable.ic_baseline_show_chart_24)
                setting.setImageResource(R.drawable.setblack)

                career.setImageResource(R.drawable.desklamp)
                textView5.setTextColor(Color.parseColor("#2c9d65"));
                textView7.setTextColor(Color.parseColor("#526474"));
                textView6.setTextColor(Color.parseColor("#526474"));
                textView8.setTextColor(Color.parseColor("#526474"));
                //resume.visibility = View.INVISIBLE
                topGuy.text = "Past Questions"
                val sums = PqFragment()
                loaddeer(sums)
            }


            R.id.open3 -> {
                startActivity(Intent(this, LeaderBoard::class.java))
                finish()
                pqBtn.setImageResource(R.drawable.pqicondark2021)
                cloud.setImageResource(R.drawable.ic_baseline_show_chart_24show)
                setting.setImageResource(R.drawable.setblack)
                /*val data = "icons"
                val data2 = "courses"
                val folder = this.getExternalFilesDir("Pronoun")
                var f = File(folder, data)
                val z = File(folder,data2)

                if (!f.exists() && !z.exists()) {
                    f.mkdir()
                    z.mkdir()
                }*/
                career.setImageResource(R.drawable.desklamp)
                textView6.setTextColor(Color.parseColor("#2c9d65"));
                textView7.setTextColor(Color.parseColor("#526474"));
                textView5.setTextColor(Color.parseColor("#526474"));
                textView8.setTextColor(Color.parseColor("#526474"));

            }


            R.id.open4 -> {

                startActivity(Intent(this, SettingsActivity::class.java))
                pqBtn.setImageResource(R.drawable.pqicondark2021)
                cloud.setImageResource(R.drawable.ic_baseline_show_chart_24)
                setting.setImageResource(R.drawable.setting)

                career.setImageResource(R.drawable.desklamp)
                textView8.setTextColor(Color.parseColor("#2c9d65"));
                textView7.setTextColor(Color.parseColor("#526474"));
                textView6.setTextColor(Color.parseColor("#526474"));
                textView5.setTextColor(Color.parseColor("#526474"));
            }
        }
    }


}

