package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.domain

import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel
import kotlinx.coroutines.flow.Flow

interface ComingSoonMoviesRepository {
    suspend fun getData(): Flow<List<ComingSoonMovieModel>>
}