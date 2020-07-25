package com.mhst.custom_view_assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.adapters.TaskAdapter
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by Moe Htet on 25,July,2020
 */
class ProfileFragment : Fragment() {

    companion object{
        fun newInstance() = ProfileFragment()
    }

    lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        taskAdapter = TaskAdapter()
        rvProfileFragTasks.layoutManager = LinearLayoutManager(view.context)
        rvProfileFragTasks.adapter = taskAdapter
        taskAdapter.setNewData(mutableListOf("one","two","three","four"))
    }

}