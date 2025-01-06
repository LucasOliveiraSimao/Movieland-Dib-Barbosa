package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.movielanddibbarbosa.R
import com.lucassimao.movielanddibbarbosa.core.data.createDiffCallback
import com.lucassimao.movielanddibbarbosa.core.ui.loadImage
import com.lucassimao.movielanddibbarbosa.databinding.ItemPlayNowMovieBinding
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.util.formatAsScheduleText

class PlayNowMoviesAdapter : ListAdapter<
        PlayNowMovieModel, PlayNowMovieViewHolder>
    (createDiffCallback<PlayNowMovieModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayNowMovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlayNowMovieBinding.inflate(inflater, parent, false)
        return PlayNowMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayNowMovieViewHolder, position: Int) {
        holder.setData(getItem(position))
    }
}

class PlayNowMovieViewHolder(
    private val binding: ItemPlayNowMovieBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setData(playNowMovieModel: PlayNowMovieModel) {
        with(binding) {
            ivPnmMoviePoster.loadImage(playNowMovieModel.posterImageUrl, R.drawable.placeholder_image)
            tvPnmMovieTitle.text = playNowMovieModel.title
            tvPnmMovieShowTimes.text = playNowMovieModel.schedule.formatAsScheduleText()
        }
    }
}