package com.shvants.balinatestapp.domain.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TabLayoutAdapter(
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = mutableListOf<Fragment>()
    private val titleList = mutableListOf<String>()

    override fun getCount() = fragmentList.size

    override fun getItem(position: Int) = fragmentList[position]

    override fun getPageTitle(position: Int) = titleList[position]

    fun addFragments(pairs: List<Pair<Fragment, String>>) {
        pairs.forEach {
            fragmentList.add(it.first)
            titleList.add(it.second)
        }
    }
}