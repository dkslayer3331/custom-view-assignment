package com.mhst.custom_view_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.views.viewholders.ProfileViewHolder

/**
 * Created by Moe Htet on 25,July,2020
 */
class ProfileAdapter : BaseRecyclerAdapter<ProfileViewHolder, String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_viewholder,parent,false)
        return  ProfileViewHolder(view)
    }

}