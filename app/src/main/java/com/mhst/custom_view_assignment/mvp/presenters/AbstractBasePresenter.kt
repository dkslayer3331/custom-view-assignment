package com.mhst.custom_view_assignment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.mhst.custom_view_assignment.mvp.views.BaseView

/**
 * Created by Moe Htet on 26,July,2020
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}