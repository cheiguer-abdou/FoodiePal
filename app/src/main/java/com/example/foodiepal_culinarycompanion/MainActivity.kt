package com.example.foodiepal_culinarycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        navigationView = findViewById(R.id.bottomNavigationView)
        viewPager2 = findViewById(R.id.viewPager2)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager2.setAdapter(viewPagerAdapter)

        // Add a TabLayout.OnTabSelectedListener
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.setCurrentItem(tab.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselection
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselection
            }
        })

        navigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Recipes -> {
                    // Handle Recipes tab selection
                    viewPager2.setCurrentItem(0, true) // Adjust the index based on your ViewPager content
                    true
                }
                R.id.MealPlanner -> {
                    // Handle Meal Planner tab selection
                    viewPager2.setCurrentItem(1, true) // Adjust the index based on your ViewPager content
                    true
                }
                R.id.Blog -> {
                    // Handle Blog tab selection
                    viewPager2.setCurrentItem(2, true) // Adjust the index based on your ViewPager content
                    true
                }
                // Add more cases for other menu items as needed
                else -> false
            }
    }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)?.select()
            }

            override fun onPageScrollStateChanged(state: Int) {
                // Handle page scroll state change
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Handle page scrolling
            }
        })
    }
}