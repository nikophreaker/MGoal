package com.providoindodigital.mgoal.ui.component

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class MatchFragmentAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    private val fragmentArrayList: ArrayList<Fragment> = ArrayList()
    private val stringArrayList: ArrayList<String> = ArrayList()

    fun addFragment(fragment: Fragment, s: String){
        fragmentArrayList.add(fragment)
        stringArrayList.add(s)
    }

    override fun getItem(position: Int): Fragment {
        return fragmentArrayList.get(position)
    }

    override fun getCount(): Int {
        return fragmentArrayList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return stringArrayList.get(position)
    }
}