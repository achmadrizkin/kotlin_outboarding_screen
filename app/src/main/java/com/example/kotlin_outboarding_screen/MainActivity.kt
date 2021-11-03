package com.example.kotlin_outboarding_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_outboarding_screen.adapter.OnBoardingViewPagerAdapter
import com.example.kotlin_outboarding_screen.model.OnBoardingData
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_indicator)

        // add data to model class
        val onBoardingData: MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Easy to add", "Lorem ipsum dolor sit amet\nconsectetur adipiscing elit.", R.drawable.notes1))
        onBoardingData.add(OnBoardingData("Easy to use", "Lorem ipsum dolor sit amet\nconsectetur adipiscing elit.", R.drawable.notes2))
        onBoardingData.add(OnBoardingData("Keep notes", "Lorem ipsum dolor sit amet\nconsectetur adipiscing elit.", R.drawable.notes3))

        setOnBoardingViewPagerAdapter(onBoardingData)

    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>) {
        onBoardingViewPager = findViewById(R.id.screemPager)
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter

        // set tab layout
        tabLayout?.setupWithViewPager(onBoardingViewPager)

    }
}