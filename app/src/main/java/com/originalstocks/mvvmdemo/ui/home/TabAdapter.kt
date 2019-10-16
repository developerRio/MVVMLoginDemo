package com.originalstocks.mvvmdemo.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return HomeOneFragment()
            }
            1 -> {
                return HomeFragment()
            }

            else -> return Fragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }

}