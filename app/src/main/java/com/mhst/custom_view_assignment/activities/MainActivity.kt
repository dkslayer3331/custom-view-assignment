package com.mhst.custom_view_assignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.adapters.ProfileAdapter
import com.mhst.custom_view_assignment.delegate.Delegate
import com.mhst.custom_view_assignment.utils.ItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Delegate {

    lateinit var profileAdapter: ProfileAdapter

    private fun setupRecycler(){
        profileAdapter = ProfileAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this@MainActivity).apply {
           stackFromEnd = true
        }
        rvProfiles.apply {
            adapter = profileAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(ItemDecorator(-60))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        profileAdapter.setNewData(mutableListOf("one","two","three","four"))
    }

    override fun onTap() {
        startActivity(ProfileActivity.onNewIntent(this))
    }
}