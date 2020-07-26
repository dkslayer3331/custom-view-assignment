package com.mhst.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.custom_view_assignment.mvp.views.MainView

/**
 * Created by Moe Htet on 26,July,2020
 */
class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mView?.showData()
    }

    override fun onTap() {
        mView?.navigateToProfile()
    }
}