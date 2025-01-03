package com.lucassimao.movielanddibbarbosa.core.ui

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String?, placeholder: Int) {
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions.placeholderOf(placeholder))
        .into(this)
}