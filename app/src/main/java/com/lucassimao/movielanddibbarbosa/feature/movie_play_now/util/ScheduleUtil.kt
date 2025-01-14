package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.util

import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.ScheduleModel

fun List<ScheduleModel>.formatAsScheduleText(): String {
    return joinToString("\n") { schedule ->
        val hoursFormatted = schedule.hour.joinToString(", ")
        "${schedule.day}: $hoursFormatted"
    }
}