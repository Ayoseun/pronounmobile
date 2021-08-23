package com.mushroom.pronoun.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.mushroom.pronoun.R
import com.mushroom.pronoun.questionaires.*
import org.json.JSONArray
import java.io.File
import java.io.IOException


class PqFragment : Fragment() {
    lateinit var listV: ListView
    var arr = arrayListOf<String>()
    lateinit var arrayAdapt: ArrayAdapter<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dee = inflater.inflate(R.layout.fragment_pq, container, false)

        val searchView = dee.findViewById<SearchView>(R.id.seachView)

        listV = dee.findViewById(R.id.listv)
        loadJson()
        arrayAdapt = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, arr)
        listV.adapter = arrayAdapt


        listV.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, id ->
                when (position) {

                    0 -> {
                        startActivity(Intent(activity, PQActivity::class.java))

                    }
                    1 -> {
                        startActivity(Intent(activity, PQActivity2::class.java))

                    }
                    2 -> {
                        startActivity(Intent(activity, PQActivity3::class.java))
                    }
                    3 -> {

                        startActivity(Intent(activity, PQActivity4::class.java))
                    }
                    4 -> {
                        startActivity(Intent(activity, PQActivity5::class.java))
                    }
                    5 -> {
                        startActivity(Intent(activity, PQActivity6::class.java))
                    }
                    6 -> {

                        startActivity(Intent(activity, PQActivity7::class.java))
                    }
                    7 -> {
                        startActivity(Intent(activity, PQActivity8::class.java))
                    }
                    8 -> {
                        startActivity(Intent(activity, PQActivity9::class.java))
                    }
                    9 -> {

                        startActivity(Intent(activity, PQActivity10::class.java))
                    }
                    10 -> {
                        startActivity(Intent(activity, PQActivity11::class.java))
                    }
                    11 -> {
                        startActivity(Intent(activity, PQActivity12::class.java))
                    }
                    12 -> {

                        startActivity(Intent(activity, PQActivity13::class.java))
                    }
                    13 -> {
                        startActivity(Intent(activity, PQActivity14::class.java))
                    }
                    14 -> {
                        startActivity(Intent(activity, PQActivity15::class.java))
                    }

                }
            }

        //searchView listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()


                if (arr.contains(p0)) {
                    arrayAdapt.filter.filter(p0)
                } else {
                    Toast.makeText(activity, "match failed", Toast.LENGTH_SHORT).show()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                arrayAdapt.filter.filter(p0)
                return false
            }

        })
        return dee
    }


    //json query
    fun loadJson() {
        val json: String?
        //try ,catch used to avoid exception issues
        try {
            val inputStream: File? =
                requireActivity().getExternalFilesDir("Pronoun/Data/list.json")  //here is where we put the json file
            json = inputStream?.bufferedReader().use { it?.readText() }
            val jsonArr = JSONArray(json) //we set json to array
            //now we iterate array
            for (i in 0 until jsonArr.length()) {
                val jsonObj = jsonArr.getJSONObject(i)
                //now we tie variables to content of our json
                val quest = jsonObj.getString("code")


                //now lets add the json contents stored in these variables into our data class

                arr.add(quest)

            }
        } catch (e: IOException) {
            Toast.makeText(activity, "Couldn't load file", Toast.LENGTH_SHORT).show()
        }

    }
}