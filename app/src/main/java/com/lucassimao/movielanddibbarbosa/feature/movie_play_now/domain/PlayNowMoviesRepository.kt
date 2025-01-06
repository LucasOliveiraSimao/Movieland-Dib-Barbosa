package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain

import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel
import kotlinx.coroutines.flow.Flow

interface PlayNowMoviesRepository {
    suspend fun getData(): Flow<List<PlayNowMovieModel>>
}