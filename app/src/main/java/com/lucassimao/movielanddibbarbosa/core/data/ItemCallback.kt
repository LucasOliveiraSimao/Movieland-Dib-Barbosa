package com.lucassimao.movielanddibbarbosa.core.data

import androidx.recyclerview.widget.DiffUtil

fun <T : DiffItem<T>> createDiffCallback(): DiffUtil.ItemCallback<T> {
    return object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.areItemsTheSame(newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }
    }
}