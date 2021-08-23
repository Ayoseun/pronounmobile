package com.mushroom.pronoun.view


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mushroom.pronoun.Adapters.ActAdapter
import com.mushroom.pronoun.R
import com.mushroom.pronoun.database.DatabaseHelper
import com.mushroom.pronoun.model.*

import kotlinx.android.synthetic.main.fragment_my_activities.*
import org.json.JSONArray
import java.io.File
import java.io.IOException
import java.io.InputStream


class myActivitiesFragment : Fragment(), CellClickListner2 {

    lateinit var databaseHelper: DatabaseHelper
    var getTimes: String? = null
    val custom4 = ArrayList<Score>()
    val custom3 = ArrayList<TotalCourse>()
    val custom = ArrayList<Clist2>()
    val custom2 = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_my_activities, container, false)
        val kiss2 = view!!.findViewById<RecyclerView>(R.id.kiss2)

        databaseHelper = DatabaseHelper(requireContext())
        progress()
        Score()
        TotalScore()
        // db = Room.databaseBuilder(applicationContext, AppDb::class.java, "BookDB").build()
        run {
            val window = requireActivity().window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#12526474")
        }


        val listed = ActAdapter(requireActivity(), this, custom2, custom3, custom4, custom)
        kiss2.adapter = listed
        kiss2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        loadJson()
        // Inflate the layout for this fragment
        //getData()


        return view

    }


    fun loadJson() {

        //var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "BookDB").build()
        val json: String?
        //try ,catch used to avoid exception issues
        try {
            val inputStream: File? =
                requireActivity().getExternalFilesDir("Pronoun/Data/list.json")  //here is where we put the json file
            json = inputStream!!.bufferedReader().use { it.readText() }
            val jsonArr = JSONArray(json) //we set json to array
            //now we iterate array
            for (i in 0 until jsonArr.length()) {
                val jsonObj = jsonArr.getJSONObject(i)
                //now we tie variables to content of our json
                val quest = jsonObj.getString("code")
                custom.add(Clist2(quest))
            }
        } catch (e: IOException) {
            Toast.makeText(activity, "Couldn't load file", Toast.LENGTH_SHORT).show()
        }

    }

    fun Score() {
        val arr = arrayOf(
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.1f,
            1.2f,
            1.0f,
            0.5f,
            1.1f
        )
        val result = databaseHelper.getData()
        if (result?.count == 0) {
            (arr.indices).forEach {
                val each = arr[it]
                custom4.add(Score(each.toString()))
            }
        }
        if (result!!.moveToFirst()) {
            do {
                val pq = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq)))
                val pq2 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq2)))
                val pq3 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq3)))
                val pq4 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq4)))
                val pq5 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq5)))
                val pq6 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq6)))
                val pq7 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq7)))
                val pq8 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq8)))
                val pq9 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq9)))
                val pq10 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq10)))
                val pq11 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq11)))
                val pq12 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq12)))
                val pq13 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq13)))
                val pq14 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq14)))
                val pq15 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq15)))

                (arr.indices).forEach {
                    arr[0] = pq.toFloat()
                    arr[1] = pq2.toFloat()
                    arr[2] = pq3.toFloat()
                    arr[3] = pq4.toFloat()
                    arr[4] = pq5.toFloat()
                    arr[5] = pq6.toFloat()
                    arr[6] = pq7.toFloat()
                    arr[7] = pq8.toFloat()
                    arr[8] = pq9.toFloat()
                    arr[9] = pq10.toFloat()
                    arr[10] = pq11.toFloat()
                    arr[11] = pq12.toFloat()
                    arr[12] = pq13.toFloat()
                    arr[13] = pq14.toFloat()
                    arr[14] = pq15.toFloat()
                    //Toast.makeText(activity, "${getName.toFloat()}", Toast.LENGTH_SHORT).show()
                    val each = arr[it]
                    custom4.add(Score(each.toString()))
                }
            } while (result.moveToNext())

        }
    }

    fun TotalScore() {

        val arr = arrayOf(
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.1f,
            10.2f,
            10.0f,
            10.5f,
            10.1f
        )
        val result = databaseHelper.getData()
        if (result?.count == 0) {
            (arr.indices).forEach {
                val each = arr[it]
                custom3.add(TotalCourse(each.toString()))
            }
        }
        if (result!!.moveToFirst()) {
            do {
                val pq = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq01)))
                val pq2 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq02)))
                val pq3 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq03)))
                val pq4 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq04)))
                val pq5 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq05)))
                val pq6 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq06)))
                val pq7 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq07)))
                val pq8 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq08)))
                val pq9 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq09)))
                val pq10 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq010)))
                val pq11 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq011)))
                val pq12 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq012)))
                val pq13 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq013)))
                val pq14 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq014)))
                val pq15 = result.getString((result.getColumnIndex(DatabaseHelper.columns_pq015)))
                (arr.indices).forEach {
                    arr[0] = pq.toFloat()
                    arr[1] = pq2.toFloat()
                    arr[2] = pq3.toFloat()
                    arr[3] = pq4.toFloat()
                    arr[4] = pq5.toFloat()
                    arr[5] = pq6.toFloat()
                    arr[6] = pq7.toFloat()
                    arr[7] = pq8.toFloat()
                    arr[8] = pq9.toFloat()
                    arr[9] = pq10.toFloat()
                    arr[10] = pq11.toFloat()
                    arr[11] = pq12.toFloat()
                    arr[12] = pq13.toFloat()
                    arr[13] = pq14.toFloat()
                    arr[14] = pq15.toFloat()
                    //Toast.makeText(activity, "${getemail.toFloat()}", Toast.LENGTH_SHORT).show()
                    val each = arr[it]
                    custom3.add(TotalCourse(each.toString()))
                }
            } while (result.moveToNext())

        }

    }


    fun progress() {
        val mtcolor = Constants.fore
        (mtcolor.indices).forEach {
            val getters = mtcolor[it]
            custom2.add(getters)
        }
    }


    fun delete(pos: Int) {
        val data = databaseHelper.delete(pos.toString())
        Log.i("Saved", "$data Data deleted")
    }

    override fun onCellClickListener2(pos: Int) {


        when (pos) {
            0 -> {
                textView18.text = "Total Attempts : $getTimes"
                delete(1)
            }
        }
    }

    fun calculator() {
        val times = 6
        val score = 10
        val totalScore = 10
        val solve = score / totalScore * 10 - times
    }
}