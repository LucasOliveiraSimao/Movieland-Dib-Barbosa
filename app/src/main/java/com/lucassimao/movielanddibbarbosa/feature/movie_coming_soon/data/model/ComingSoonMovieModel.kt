package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model

import com.lucassimao.movielanddibbarbosa.core.data.DiffItem

data class ComingSoonMovieModel(
    val movieId: Int?,
    val title: String?,
    val posterImageUrl: String?,
    val schedule: List<Map<String, List<String>>> = emptyList()
) : DiffItem<ComingSoonMovieModel> {
    override fun areItemsTheSame(other: ComingSoonMovieModel): Boolean {
        return movieId == other.movieId
    }

    override fun areContentsTheSame(other: ComingSoonMovieModel): Boolean {
        return this == other
    }
}