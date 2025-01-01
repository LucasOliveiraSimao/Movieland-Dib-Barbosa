package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.util

fun List<Map<String, List<String>>>.formatAsScheduleText(): String {
    return joinToString("\n") { map ->
        map.entries.joinToString("\n") { (day, times) ->
            "$day: ${times.joinToString(", ")}"
        }
    }
}