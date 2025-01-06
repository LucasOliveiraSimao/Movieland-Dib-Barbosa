package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model

import com.lucassimao.movielanddibbarbosa.core.data.DiffItem

data class PlayNowMovieModel(
    val movieId: Int?,
    val title: String?,
    val posterImageUrl: String?,
    val schedule: List<Map<String, List<String>>> = emptyList()
) : DiffItem<PlayNowMovieModel> {
    override fun areItemsTheSame(other: PlayNowMovieModel): Boolean {
        return movieId == other.movieId
    }

    override fun areContentsTheSame(other: PlayNowMovieModel): Boolean {
        return this == other
    }
}