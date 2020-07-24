package com.mhst.custom_view_assignment.views.viewholders

import android.view.View
import com.mhst.custom_view_assignment.R
import kotlinx.android.synthetic.main.profile_viewholder.view.*

/**
 * Created by Moe Htet on 25,July,2020
 */
class ProfileViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {

    init {
        itemView.setOnClickListener {

        }
    }

    override fun bindData(data: String) {
        if(data == "plus") itemView.ivProfile.setBackgroundResource(R.drawable.plus_icon)
        itemView.ivProfile.setBackgroundResource(R.drawable.funny_dazai)
    }
}