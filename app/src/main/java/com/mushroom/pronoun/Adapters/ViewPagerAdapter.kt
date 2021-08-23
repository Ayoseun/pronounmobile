package com.mushroom.pronoun.Adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mushroom.pronoun.R
import com.mushroom.pronoun.view.CellClickListner
import kotlinx.android.synthetic.main.car_view_list_layout.view.*
import java.io.File


class ViewPagerAdapter(
    private val images: ArrayList<File>, val celle: CellClickListner
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_view_list_layout, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        //holder.itemView.study2.setImageResource(curImage.icons)
        Glide.with(holder.itemView.context)
            .load(curImage)
            .into(holder.itemView.study2)


        holder.itemView.setOnClickListener {
            celle.onCellClickListener(position)
        }

    }


}








