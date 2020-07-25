package com.mhst.custom_view_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.views.viewholders.TaskViewHolder

/**
 * Created by Moe Htet on 25,July,2020
 */
class TaskAdapter : BaseRecyclerAdapter<TaskViewHolder, String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpod_task,parent,false)
        return TaskViewHolder(view)
    }
}