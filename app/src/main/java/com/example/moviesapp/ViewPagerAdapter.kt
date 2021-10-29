package com.example.moviesapp

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(supportFragmentManager:FragmentManager) : FragmentPagerAdapter(supportFragmentManager) {

    private val FragmentList = ArrayList<Fragment>()
    private val FragmentTitleList = ArrayList<String>()


    override fun getCount(): Int {
        return FragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return FragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return FragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment,title:String){
        FragmentList.add(fragment)
        FragmentTitleList.add(title)
    }

}