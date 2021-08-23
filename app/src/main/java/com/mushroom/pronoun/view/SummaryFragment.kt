package com.mushroom.pronoun.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mushroom.pronoun.Adapters.ViewPagerAdapter
import com.mushroom.pronoun.R
import com.mushroom.pronoun.summaries.summary
import java.io.File


class LandSummaryFragment : Fragment(), CellClickListner {

    val a: ArrayList<File> = ArrayList()
    lateinit var deeAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v: View = inflater.inflate(R.layout.fragment_summary, container, false)
        val line = v.findViewById<LinearLayout>(R.id.line)
        val stayPager = v.findViewById<ViewPager2>(R.id.stayPager)

        val root: File? = requireActivity().getExternalFilesDir("Pronoun/Data")
        if (root != null) {
            if (root.exists()) {
                val files = root.listFiles()
                if (files!!.isNotEmpty()) {
                    for (i in files.indices) {
                        if (files[i].name.endsWith(".png")) {
                            a.add(files[i])
                            files.last().name
                            deeAdapter = ViewPagerAdapter(a, this)
                            deeAdapter.hasObservers()
                            stayPager.adapter = deeAdapter
                            stayPager.orientation = ViewPager2.ORIENTATION_VERTICAL

                            stayPager.beginFakeDrag()
                            stayPager.fakeDragBy(-2f)
                            stayPager.endFakeDrag()
                            //Toast.makeText(activity,"works${a.size}",Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }
        //firstScreen()
        return v

    }


    override fun onCellClickListener(pos: Int) {
        when (pos) {

            0 -> {
                startActivity(Intent(activity, summary::class.java))
            }

        }
    }
}