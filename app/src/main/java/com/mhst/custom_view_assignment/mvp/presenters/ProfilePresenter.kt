package com.mhst.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.custom_view_assignment.mvp.views.ProfileView

/**
 * Created by Moe Htet on 26,July,2020
 */
interface ProfilePresenter : BasePresenter<ProfileView>{
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}