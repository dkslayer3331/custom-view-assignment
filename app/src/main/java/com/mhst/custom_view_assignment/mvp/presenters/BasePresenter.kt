package com.mhst.custom_view_assignment.mvp.presenters

import com.mhst.custom_view_assignment.mvp.views.BaseView

/**
 * Created by Moe Htet on 26,July,2020
 */
interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}