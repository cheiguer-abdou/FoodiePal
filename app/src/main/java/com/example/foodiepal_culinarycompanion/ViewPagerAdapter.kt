package com.example.foodiepal_culinarycompanion

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        val dayString = when (position) {
            0 -> Recipes()
            1 -> MealPlanner()
            2 -> Blog()
            3 -> Contact()
            4 -> AboutMe()
            else -> Recipes()
        }
        return dayString
    }
}