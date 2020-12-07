package com.mushroom.trial.utils

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.mushroom.trial.Adapters.ViewPagerAdapter
import com.mushroom.trial.Adapters.ViewPagerAdapter2
import com.mushroom.trial.R
import com.mushroom.trial.model.ItemList
import com.mushroom.trial.questionaires.Constants
import com.mushroom.trial.questionaires.PQActivity
import com.mushroom.trial.questionaires.Question
import kotlinx.android.synthetic.main.activity_landpage.*

class landPage : AppCompatActivity(),CellClickListner,CellClickListner2 {

    private var images: ArrayList<ItemList>? =null
    var checkers : ArrayList<Question>? = null
    private var memailName: String? = null
     var smile : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landpage)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val pqBtn = findViewById<ImageButton>(R.id.pqBtn)
        val setting = findViewById<ImageButton>(R.id.setting)
        val career = findViewById<ImageButton>(R.id.career)
        val cloud = findViewById<ImageButton>(R.id.cloud)



        firstScreen()


        pqBtn.setOnClickListener(View.OnClickListener {
            secondScreen()
            resume.visibility = View.INVISIBLE
            topGuy.text="Past Questions"
        })

        setting.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, PQActivity::class.java))
        })

        cloud.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, PQActivity::class.java))
        })

        career.setOnClickListener(View.OnClickListener {
            firstScreen()
            resume.visibility = View.VISIBLE
                    topGuy.text="Semester Mode"
        })



        memailName = intent.getStringExtra(Constants.USER_NAME)

        landname.text = memailName

    }

    private fun firstScreen() {

        var stay: ArrayList<ItemList> = ArrayList()

        stay.add(
            ItemList(
                R.drawable.study,
                "Ecn211"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Stt233"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Pol211"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Pdu201"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Gst211"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Mth271"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Ecn211"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "mth215"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Ecn213"
            )
        )
        stay.add(
            ItemList(
                R.drawable.study,
                "Stt211"
            )
        )

        val deeAdapter = ViewPagerAdapter(stay,this)
        stayPager.adapter = deeAdapter
        stayPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        stayPager.beginFakeDrag()
        stayPager.fakeDragBy(-2f)
        stayPager.endFakeDrag()
    }


    private fun secondScreen() {


        var stay2: ArrayList<ItemList> = ArrayList()

        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Ecn211"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Stt233"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Pol211"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Pdu201"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Gst211"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Mth271"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Ecn211"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Ecn213"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "Ecn213"
            )
        )
        stay2.add(
            ItemList(
                R.drawable.pqiconwhite,
                "pad211"
            )
        )

        val deeAdapter = ViewPagerAdapter2(stay2,this)
        stayPager.adapter = deeAdapter
        stayPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        stayPager.beginFakeDrag()
        stayPager.fakeDragBy(-2f)
        stayPager.endFakeDrag()
    }

    override fun onCellClickListener(curImage : ItemList) {

        Toast.makeText(this,"${curImage.details} it is working \nbut not available yet",Toast.LENGTH_LONG).show()


        }
    override fun onCellClickListener2(eduImage : ItemList) {

        startActivity(Intent(this, PQActivity::class.java))

    }

}




