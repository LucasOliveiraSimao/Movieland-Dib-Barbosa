package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model

import com.lucassimao.movielanddibbarbosa.core.data.DiffItem

data class PlayNowMovieModel(
    val id: Int = 0,
    val name: String = "",
    val posterUrl: String = "",
    val schedules: List<ScheduleModel> = emptyList()
) : DiffItem<PlayNowMovieModel> {
    override fun areItemsTheSame(other: PlayNowMovieModel): Boolean {
        return id == other.id
    }

    override fun areContentsTheSame(other: PlayNowMovieModel): Boolean {
        return this == other
    }
}