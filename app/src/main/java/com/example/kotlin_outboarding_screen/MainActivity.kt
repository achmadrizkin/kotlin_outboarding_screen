package com.example.kotlin_outboarding_screen

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_outboarding_screen.adapter.OnBoardingViewPagerAdapter
import com.example.kotlin_outboarding_screen.model.OnBoardingData
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null
    var next: TextView? = null
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_indicator)
        next = findViewById(R.id.next)

        // add data to model class
        val onBoardingData: MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Easy to add", "Lorem ipsum dolor sit amet\nconsectetur adipiscing elit.", R.drawable.notes1))
        onBoardingData.add(OnBoardingData("Easy to use", "Lorem ipsum dolor sit amet\nconsectetur adipiscing elit.", R.drawable.notes2))
        onBoardingData.add(OnBoardingData("Keep notes", "Lorem ipsum dolor sit amet\nconsectetur adipiscing elit.", R.drawable.notes3))

        setOnBoardingViewPagerAdapter(onBoardingData)
        position = onBoardingViewPager!!.currentItem

        //
        next?.setOnClickListener {
            if (position < onBoardingData.size) {
                position++
                onBoardingViewPager!!.currentItem = position
            }
        }

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingData.size - 1) {
                    next!!.text == "Get Started"
                } else {
                    next!!.text == "Next"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })


    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>) {
        onBoardingViewPager = findViewById(R.id.screemPager)
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter

        // set tab layout
        tabLayout?.setupWithViewPager(onBoardingViewPager)

    }
}