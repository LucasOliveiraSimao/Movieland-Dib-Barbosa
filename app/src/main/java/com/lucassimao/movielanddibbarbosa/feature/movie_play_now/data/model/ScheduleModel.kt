package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model

data class ScheduleModel(
    val day: String = "",
    val hour: List<String> = emptyList()
)