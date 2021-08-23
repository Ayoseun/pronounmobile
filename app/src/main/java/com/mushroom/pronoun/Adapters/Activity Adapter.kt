package com.mushroom.pronoun.Adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mushroom.pronoun.R
import com.mushroom.pronoun.model.Clist2
import com.mushroom.pronoun.model.Clist3
import com.mushroom.pronoun.model.Score
import com.mushroom.pronoun.model.TotalCourse
import com.mushroom.pronoun.view.CellClickListner2
import kotlinx.android.synthetic.main.slate2.view.*


class ActAdapter(
    val context: Context,
    val celle: CellClickListner2,
    private val Pb: ArrayList<String>,
    private var allCourse: ArrayList<TotalCourse>,
    private val score: ArrayList<Score>,
    private val Act: ArrayList<Clist2>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.slate2, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        allCourse.size
        score.size
        return Act.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val guess = Act[position]
        val score = score[position]
        val total = allCourse[position]
        holder.itemView.show.text = guess.mcListTxt

        holder.itemView.cProgress.apply {
            val go = Pb[position]
            progress = score.score.toFloat()

            progressMax = total.course.toFloat()

            progressBarColor = Color.parseColor(go)
        }




        holder.itemView.setOnClickListener {
            celle.onCellClickListener2(position)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!),
        View.OnClickListener {
        init {
            itemView?.setOnClickListener(this)
        }


        // val dogImage: TextView = itemView!!.show
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

}
