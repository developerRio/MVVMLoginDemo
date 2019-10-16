package com.originalstocks.mvvmdemo.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.originalstocks.mvvmdemo.R
import com.originalstocks.mvvmdemo.databinding.ActivityTabBinding
import com.originalstocks.mvvmdemo.ui.auth.AuthViewModel

class TabActivity : AppCompatActivity()   {
    private val TAG = "TabActivity"

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityTabBinding = DataBindingUtil.setContentView(this, R.layout.activity_tab)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel:: class.java)
        binding.viewmodel = viewModel

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Login"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Home"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(
            this,
            supportFragmentManager,
            tabLayout!!.tabCount
        )
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }// onCreate closes




}
