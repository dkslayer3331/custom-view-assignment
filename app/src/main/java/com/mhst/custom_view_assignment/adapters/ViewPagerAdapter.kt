package com.mhst.custom_view_assignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mhst.custom_view_assignment.fragments.ProfileFragment

/**
 * Created by Moe Htet on 25,July,2020
 */
class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return ProfileFragment.newInstance()
    }
}