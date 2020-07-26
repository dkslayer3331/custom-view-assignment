package com.mhst.custom_view_assignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayoutMediator
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.adapters.ProfileAdapter
import com.mhst.custom_view_assignment.adapters.ViewPagerAdapter
import com.mhst.custom_view_assignment.mvp.presenters.ProfilePresenter
import com.mhst.custom_view_assignment.mvp.presenters.ProfilePresenterImpl
import com.mhst.custom_view_assignment.mvp.views.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),ProfileView {

    lateinit var profilePresenter : ProfilePresenter

    private val tabTitles = listOf("Project Tasks","Contacts","About You")


    private fun setupPresenter(){
        profilePresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        profilePresenter.initPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupPresenter()

        pager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tab_layout,pager){ tab, pos->
            tab.text = tabTitles[pos]
        }.attach()

        profilePresenter.onUiReady(this)

    }

    companion object{
        fun onNewIntent(context: Context) : Intent {
            return Intent(context,
                ProfileActivity::class.java)
        }
    }

    override fun showData() {

    }

}