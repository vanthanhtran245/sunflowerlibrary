package com.thanhtv.sunflowerlibrary.extensions.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.thanhtv.sunflowerlibrary.extensions.ui.adapter.ArrayAdapterEx


open class QuickAdapter<T>(
        ctx: Context,
        protected val layoutId: Int,
        protected val bind: (QuickViewBinder, T) -> Unit)
: ArrayAdapterEx<T>(ctx, arrayListOf<T>()) {

    override fun newView(position: Int, parent: ViewGroup): View {
        val binder = QuickViewBinder(context,
                inflater.inflate(layoutId, parent, false),
                position)
        return binder.view
    }

    override fun bindView(position: Int, view: View) {
        val binder = view.tag as QuickViewBinder
        binder.position = position
        bind(binder, getItem(position))
    }
}