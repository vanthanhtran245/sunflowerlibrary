package com.thanhtv.sunflowerlibrary.extensions.core

import android.widget.ImageView
import com.squareup.picasso.Picasso

inline fun ImageView.imageWithURL(url: String) {
    Picasso.with(this.context)
            .load(url)
            .centerCrop()
            .into(this)
}