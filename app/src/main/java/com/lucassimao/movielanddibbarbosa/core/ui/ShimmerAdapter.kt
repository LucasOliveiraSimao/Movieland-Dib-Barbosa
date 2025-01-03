package com.lucassimao.movielanddibbarbosa.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class ShimmerAdapter(private val itemCount: Int = 10, @LayoutRes private val layoutShimmer: Int) :
    RecyclerView.Adapter<ShimmerAdapter.ShimmerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShimmerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(layoutShimmer, parent, false)
        return ShimmerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShimmerViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = itemCount

    inner class ShimmerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}