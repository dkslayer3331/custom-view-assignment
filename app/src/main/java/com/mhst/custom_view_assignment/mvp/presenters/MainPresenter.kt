package com.mhst.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.custom_view_assignment.delegate.Delegate
import com.mhst.custom_view_assignment.mvp.views.MainView

/**
 * Created by Moe Htet on 26,July,2020
 */
interface MainPresenter :  BasePresenter<MainView>,Delegate{
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
    fun navigateToTask()
}