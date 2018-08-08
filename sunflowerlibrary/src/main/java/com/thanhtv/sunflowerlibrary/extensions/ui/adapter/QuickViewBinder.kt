package com.thanhtv.sunflowerlibrary.extensions.ui.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.util.Linkify
import android.view.View
import android.widget.*



open class QuickViewBinder constructor(
        val context: Context,
        val view: View,
        var position: Int) {

    init {
        view.tag = this
    }

    private inline fun <reified T : View> findView(viewId: Int): T = view.findViewById(viewId) as T

    fun setText(viewId: Int, value: String): QuickViewBinder {
        findView<TextView>(viewId).text = value
        return this
    }

    fun setImageResource(viewId: Int, imageResId: Int): QuickViewBinder {
        findView<ImageView>(viewId).setImageResource(imageResId)
        return this
    }

    fun setBackgroundColor(viewId: Int, color: Int): QuickViewBinder {
        findView<View>(viewId).setBackgroundColor(color)
        return this
    }

    fun setBackgroundRes(viewId: Int, backgroundRes: Int): QuickViewBinder {
        findView<View>(viewId).setBackgroundResource(backgroundRes)
        return this
    }

    fun setTextColor(viewId: Int, textColor: Int): QuickViewBinder {
        findView<TextView>(viewId).setTextColor(textColor)
        return this
    }

    fun setTextColorRes(viewId: Int, textColorRes: Int): QuickViewBinder {
        findView<TextView>(viewId).setTextColor(context.resources.getColor(textColorRes))
        return this
    }

    fun setImageDrawable(viewId: Int, drawable: Drawable): QuickViewBinder {
        findView<ImageView>(viewId).setImageDrawable(drawable)
        return this
    }

    fun setImageBitmap(viewId: Int, bitmap: Bitmap): QuickViewBinder {
        findView<ImageView>(viewId).setImageBitmap(bitmap)
        return this
    }

    fun setAlpha(viewId: Int, value: Float): QuickViewBinder {
        findView<View>(viewId).alpha = value
        return this
    }

    fun setVisible(viewId: Int, visible: Boolean): QuickViewBinder {
        findView<View>(viewId).visibility = if (visible) View.VISIBLE else View.GONE
        return this
    }

    fun linkify(viewId: Int): QuickViewBinder {
        Linkify.addLinks(findView<TextView>(viewId), Linkify.ALL)
        return this
    }

    fun setOnClickListener(viewId: Int,
                           listener: View.OnClickListener): QuickViewBinder {
        findView<View>(viewId).setOnClickListener(listener)
        return this
    }

    fun setOnTouchListener(viewId: Int,
                           listener: View.OnTouchListener): QuickViewBinder {
        findView<View>(viewId).setOnTouchListener(listener)
        return this
    }

    fun setOnLongClickListener(viewId: Int,
                               listener: View.OnLongClickListener)
            : QuickViewBinder {
        findView<View>(viewId).setOnLongClickListener(listener)
        return this
    }

    fun setOnItemClickListener(viewId: Int,
                               listener: AdapterView.OnItemClickListener)
            : QuickViewBinder {
        findView<AdapterView<Adapter>>(viewId).onItemClickListener = listener
        return this
    }

    fun setOnItemLongClickListener(viewId: Int,
                                   listener: AdapterView.OnItemLongClickListener)
            : QuickViewBinder {
        findView<AdapterView<Adapter>>(viewId).onItemLongClickListener = listener
        return this
    }

    fun setChecked(viewId: Int, checked: Boolean): QuickViewBinder {
        (findView<View>(viewId) as Checkable).isChecked = checked
        return this
    }

}