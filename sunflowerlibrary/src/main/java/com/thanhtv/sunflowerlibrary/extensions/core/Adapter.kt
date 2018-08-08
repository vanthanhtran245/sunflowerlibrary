package com.thanhtv.sunflowerlibrary.extensions.core

import android.app.Activity
import com.thanhtv.sunflowerlibrary.extensions.ui.adapter.QuickAdapter
import com.thanhtv.sunflowerlibrary.extensions.ui.adapter.QuickViewBinder


fun <T : Any> Activity.quickAdapterOf(
        layoutId: Int,
        items: Collection<T>,
        bind: ((QuickViewBinder, T) -> Unit))
        : QuickAdapter<T> {
    val adapter = quickAdapterOf(layoutId, bind)
    adapter.addAll(items)
    return adapter
}

fun <T : Any> Activity.quickAdapterOf(
        layoutId: Int,
        items: Array<T>,
        bind: ((QuickViewBinder, T) -> Unit))
        : QuickAdapter<T> {
    val adapter = quickAdapterOf(layoutId, bind)
    adapter.addAll(items.toList())
    return adapter
}

fun <T : Any> Activity.quickAdapterOf(
        layoutId: Int,
        items: Set<T>,
        bind: ((QuickViewBinder, T) -> Unit))
        : QuickAdapter<T> {
    val adapter = quickAdapterOf(layoutId, bind)
    adapter.addAll(items)
    return adapter
}

fun <T : Any> Activity.quickAdapterOf(
        layoutId: Int,
        bind: ((QuickViewBinder, T) -> Unit))
        : QuickAdapter<T> {
    return QuickAdapter(this, layoutId, bind)
}
