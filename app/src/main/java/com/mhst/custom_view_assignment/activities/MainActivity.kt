package com.mhst.custom_view_assignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.adapters.ProfileAdapter
import com.mhst.custom_view_assignment.adapters.TaskAdapter
import com.mhst.custom_view_assignment.delegate.Delegate
import com.mhst.custom_view_assignment.mvp.presenters.MainPresenter
import com.mhst.custom_view_assignment.mvp.presenters.MainPresenterImpl
import com.mhst.custom_view_assignment.mvp.views.MainView
import com.mhst.custom_view_assignment.utils.ItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Delegate,MainView {

    lateinit var profileAdapter: ProfileAdapter

    lateinit var taskAdapter : TaskAdapter

    lateinit var mainPresenter : MainPresenter

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

    private fun setupMainPresenter(){
        mainPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mainPresenter.initPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMainPresenter()

        setupProfileRecycler()
        setupTaskAdapter()

        showData()

        ivCreateTask.setOnClickListener {
            mainPresenter.navigateToTask()
        }

        mainPresenter.onUiReady(this)


    }

    override fun onTap() {
        startActivity(ProfileActivity.onNewIntent(this))
    }

    override fun showData() {
        profileAdapter.setNewData(mutableListOf("one","two","three","four"))
        taskAdapter.setNewData(mutableListOf("one","two","three","four"))
    }

    override fun navigateToProfile() {
        startActivity(ProfileActivity.onNewIntent(this))
    }

    override fun naviageToTask() {
        startActivity(CreateTaskActivity.onNewIntent(this))
    }
}