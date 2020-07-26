package com.mhst.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.custom_view_assignment.mvp.views.CreateTaskView

/**
 * Created by Moe Htet on 26,July,2020
 */
class CreateTaskPresenterImpl : CreateTaskPresenter, AbstractBasePresenter<CreateTaskView>() {
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mView?.showData()
    }
}