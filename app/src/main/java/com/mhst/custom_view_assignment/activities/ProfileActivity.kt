package com.mhst.custom_view_assignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    val tabTitles = listOf("Project Tasks","Contacts","About You")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        pager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tab_layout,pager){ tab, pos->
            tab.text = tabTitles[pos]
        }.attach()

    }

    companion object{
        fun onNewIntent(context: Context) : Intent {
            return Intent(context,
                ProfileActivity::class.java)
        }
    }

}