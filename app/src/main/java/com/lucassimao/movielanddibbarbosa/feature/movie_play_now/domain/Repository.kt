package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain

import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMoviesModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(): Flow<PlayNowMoviesModel>
}