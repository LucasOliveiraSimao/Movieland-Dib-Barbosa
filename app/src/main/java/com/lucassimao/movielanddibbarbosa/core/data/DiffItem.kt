package com.lucassimao.movielanddibbarbosa.core.data

interface DiffItem<T> {
    fun areItemsTheSame(other: T): Boolean
    fun areContentsTheSame(other: T): Boolean
}