package com.mhst.custom_view_assignment.views.viewholders

import android.view.View
import com.mhst.custom_view_assignment.R
import com.mhst.custom_view_assignment.delegate.Delegate
import kotlinx.android.synthetic.main.profile_viewholder.view.*

/**
 * Created by Moe Htet on 25,July,2020
 */
class ProfileViewHolder(itemView: View,delegate : Delegate) : BaseViewHolder<String>(itemView) {

    init {
        itemView.setOnClickListener {
            delegate.onTap()
        }
    }

    override fun bindData(data: String) {
        itemView.ivProfile.setBackgroundResource(R.drawable.funny_dazai)
    }
}