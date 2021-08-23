package com.mushroom.pronoun.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mushroom.pronoun.UserData.login
import com.mushroom.pronoun.UserData.signup


class deepager(fm:FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
       return when(position){
            0 ->{
                login()
            }
            1->{
                signup()
            }
           else -> login()
        }

    }

    override fun getCount(): Int {
        return 2
    }


}

