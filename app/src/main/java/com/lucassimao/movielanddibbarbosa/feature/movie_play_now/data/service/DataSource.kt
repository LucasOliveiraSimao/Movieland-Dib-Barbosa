package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.service

import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMoviesModel

interface DataSource {
    suspend fun getPlayNowMovies(): PlayNowMoviesModel
}