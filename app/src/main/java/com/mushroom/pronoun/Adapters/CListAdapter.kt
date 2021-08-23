package com.mushroom.pronoun.Adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mushroom.pronoun.R
import com.mushroom.pronoun.model.cList

class CListAdapter(private val getContext: Context, private val customListITem: ArrayList<cList>) :
    ArrayAdapter<cList>(getContext, 0, customListITem)
{


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listLayout = convertView
        val holder: ViewHolder

        if (listLayout == null) {

            val inflateList = (getContext as Activity).layoutInflater
            listLayout = inflateList.inflate(R.layout.slate3, parent, false)

            holder = ViewHolder()

            holder.mtext = listLayout!!.findViewById(R.id. textView2)
            holder.mview = listLayout.findViewById(R.id.imageView)
            holder.mtext3 = listLayout.findViewById(R.id.textView47)
            listLayout.tag = holder
        }
        else
        {
            holder = listLayout.tag as ViewHolder
        }
        val listItem = customListITem[position]
        holder.mtext!!.text = listItem.mcListTxt
       // holder.mview!!.setImageResource(listItem.mview)
        holder.mtext3!!.text = listItem.mcListTxt2

        return listLayout
    }

    class ViewHolder {
        internal var mtext: TextView? = null
        internal var mview: ImageView? = null
        internal var mtext3: TextView? = null
    }
}