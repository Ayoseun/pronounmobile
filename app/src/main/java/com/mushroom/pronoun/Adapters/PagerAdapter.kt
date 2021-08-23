package com.mushroom.pronoun.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mushroom.pronoun.Onboarding.Oboarding2
import com.mushroom.pronoun.Onboarding.Onboarding1
import com.mushroom.pronoun.Onboarding.Onboarding3

internal class PagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 ->{
                Onboarding1()
            }
            1->{
                Oboarding2()
            }
            2->{
                Onboarding3()
            }
            else -> Onboarding1()
        }

    }

    override fun getCount(): Int {
        return 3
    }


}
