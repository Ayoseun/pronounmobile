package com.mushroom.pronoun.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.mushroom.pronoun.Adapters.CListAdapter
import com.mushroom.pronoun.R
import com.mushroom.pronoun.model.Constants
import com.mushroom.pronoun.model.cList
import kotlinx.android.synthetic.main.fragment_my_activities.*
import kotlinx.android.synthetic.main.slate3.*
import org.json.JSONArray
import java.io.File
import java.io.IOException
import java.io.InputStream







class LeaderBoard : AppCompatActivity() {
    val custom = ArrayList<cList>()

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this, landPage::class.java))
        finish()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader_board)

        run {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#12526474")
        }

        val kiss = findViewById<ListView>(R.id.kiss)
        val listed = CListAdapter(this,custom)
        kiss.adapter= listed

        kiss.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            when(position){
                0 ->{

                    imageView.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24)
                }
                1 ->{

                    imageView.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24)
                }
                2 ->{

                    imageView.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24)
                }
                3 ->{

                }
                4 ->{

                }
                5 ->{

                    imageView.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24)
                }
            }
        }
        loadJson()
        // Inflate the layout for this fragment
        //getData()




    }



    fun loadJson() {
        val json: String?
        //try ,catch used to avoid exception issues
        try {
            val inputStream: File? =
                this.getExternalFilesDir("Pronoun/Data/list.json")  //here is where we put the json file
            json = inputStream!!.bufferedReader().use { it.readText() }

            val jsonArr = JSONArray(json) //we set json to array
            //now we iterate array
            for (i in 0 until jsonArr.length()) {
                val jsonObj = jsonArr.getJSONObject(i)
                //now we tie variables to content of our json
                val quest = jsonObj.getString("code")
                val intent = Intent()
                val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
                val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
                val give = arrayListOf(totalQuestions,correctAnswers)
                //now lets add the json contents stored in these variables into our data class

                custom.add(cList(quest,correctAnswers.toString()))

            }
        } catch (e: IOException) {
            Toast.makeText(this,"Couldn't load file", Toast.LENGTH_SHORT).show()
        }

    }







    /*fun getData(){
        val rested : Cursor = myDb2.myscoreData()


        while (rested.moveToNext()){
            //buffersurname.append(rested.getString(2))
            // bufferdept.append(rested.getString(3))
            //buffername.append(rested.getString(2))
            a.text = rested.getString(1).toString()
            landSurname.text = rested.getString(2).toString()
            landDept.text = rested.getString(3).toString()
            cLevel.text = rested.getString(4).toString()
        }


        //landSurname.text = buffername.toString()
        //landDept.text = buffername.toString()

    }*/
}