package com.mhst.custom_view_assignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.adapters.ProfileAdapter
import com.mhst.custom_view_assignment.delegate.Delegate
import com.mhst.custom_view_assignment.mvp.views.CreateTaskView
import kotlinx.android.synthetic.main.activity_create_task.*

class CreateTaskActivity : AppCompatActivity(),Delegate,CreateTaskView {

    lateinit var profileAdapter: ProfileAdapter

    private fun setupRecycler(){
        profileAdapter = ProfileAdapter(this)
        rvAssignee.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvAssignee.adapter = profileAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        setupRecycler()

        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


    }

    companion object{
        fun onNewIntent(context: Context) : Intent{
            return Intent(context,
                CreateTaskActivity::class.java)

        }

    }

    override fun onTap() {
    }

    override fun showData() {
        profileAdapter.setNewData(mutableListOf("one","two","three"))
    }

}