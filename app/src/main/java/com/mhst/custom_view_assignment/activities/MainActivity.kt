package com.mhst.custom_view_assignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.adapters.ProfileAdapter
import com.mhst.custom_view_assignment.adapters.TaskAdapter
import com.mhst.custom_view_assignment.delegate.Delegate
import com.mhst.custom_view_assignment.utils.ItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Delegate {

    lateinit var profileAdapter: ProfileAdapter

    lateinit var taskAdapter : TaskAdapter

    private fun setupProfileRecycler(){
        profileAdapter = ProfileAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this@MainActivity).apply {
           stackFromEnd = true
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvProfiles.apply {
            adapter = profileAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(ItemDecorator(-40))
        }
    }

    private fun setupTaskAdapter(){
        taskAdapter = TaskAdapter()
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupProfileRecycler()
        setupTaskAdapter()
        profileAdapter.setNewData(mutableListOf("one","two","three","four"))
        taskAdapter.setNewData(mutableListOf("one","two","three","four"))

        ivCreateTask.setOnClickListener {
            startActivity(CreateTaskActivity.onNewIntent(this))
        }

    }

    override fun onTap() {
        startActivity(ProfileActivity.onNewIntent(this))
    }
}