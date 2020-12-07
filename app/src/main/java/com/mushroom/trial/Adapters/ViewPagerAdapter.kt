package com.mushroom.trial.Adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.mushroom.trial.R
import com.mushroom.trial.model.ItemList
import com.mushroom.trial.utils.CellClickListner
import com.mushroom.trial.utils.CellClickListner2
import kotlinx.android.synthetic.main.car_view_list_layout.view.*
import kotlinx.android.synthetic.main.slate.view.*

class ViewPagerAdapter(
    private val images: ArrayList<ItemList>, private val cellClickListner: CellClickListner)  : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){

    inner class ViewPagerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),AdapterView.OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_view_list_layout,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
       return images.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        holder.itemView.study2.setImageResource(curImage.icons!!)
        holder.itemView.tv.text= curImage.details!!
        holder.itemView.setOnClickListener {
            cellClickListner.onCellClickListener(curImage)
        }

        }
    }









class ViewPagerAdapter2(
    private val images: ArrayList<ItemList>, private val cellClickListner2: CellClickListner2
)  : RecyclerView.Adapter<ViewPagerAdapter2.ViewPagerViewHolder2>(){

    inner class ViewPagerViewHolder2(itemView : View) : RecyclerView.ViewHolder(itemView),AdapterView.OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slate,parent,false)
        return ViewPagerViewHolder2(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewPagerViewHolder2, position: Int) {
        val eduImage = images[position]
        holder.itemView.pqer.setImageResource(eduImage.icons!!)
        holder.itemView.tv2.text= eduImage.details!!
        holder.itemView.setOnClickListener {
            cellClickListner2.onCellClickListener2(eduImage)
        }

    }
}