package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.movielanddibbarbosa.R
import com.lucassimao.movielanddibbarbosa.core.Constants.URL_POSTER_PATH
import com.lucassimao.movielanddibbarbosa.core.data.createDiffCallback
import com.lucassimao.movielanddibbarbosa.core.ui.loadImage
import com.lucassimao.movielanddibbarbosa.databinding.ItemComingSoonMovieBinding
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel

class ComingSoonMoviesAdapter : ListAdapter<
        ComingSoonMovieModel, ComingSoonMovieViewHolder>
    (createDiffCallback<ComingSoonMovieModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonMovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemComingSoonMovieBinding.inflate(inflater, parent, false)
        return ComingSoonMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComingSoonMovieViewHolder, position: Int) {
        holder.setData(getItem(position))
    }
}

class ComingSoonMovieViewHolder(
    private val binding: ItemComingSoonMovieBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setData(movie: ComingSoonMovieModel) {
        with(binding) {
            ivCsmMoviePoster.loadImage(URL_POSTER_PATH + movie.posterPath, R.drawable.placeholder_image)
            tvCsmMovieTitle.text = movie.title
        }
    }
}