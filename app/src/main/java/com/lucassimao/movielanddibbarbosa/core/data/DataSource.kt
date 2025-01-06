package com.lucassimao.movielanddibbarbosa.core.data

import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel

interface DataSource {
    suspend fun getPlayNowMovies(): List<PlayNowMovieModel> {
        throw UnsupportedOperationException()
    }

    suspend fun getComingSoonMovies(): List<ComingSoonMovieModel> {
        throw UnsupportedOperationException()
    }
}