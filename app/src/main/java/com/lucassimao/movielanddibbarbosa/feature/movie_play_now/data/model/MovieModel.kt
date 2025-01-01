package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model

import com.lucassimao.movielanddibbarbosa.core.data.DiffItem

data class MovieModel(
    val movieId: Int?,
    val title: String?,
    val posterImageUrl: String?,
    val schedule: List<Map<String, List<String>>> = emptyList()
) : DiffItem<MovieModel> {
    override fun areItemsTheSame(other: MovieModel): Boolean {
        return movieId == other.movieId
    }

    override fun areContentsTheSame(other: MovieModel): Boolean {
        return this == other
    }
}