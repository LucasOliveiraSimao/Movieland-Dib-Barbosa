package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data

import com.lucassimao.movielanddibbarbosa.core.data.DataSource
import com.lucassimao.movielanddibbarbosa.core.di.PlayNow
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain.PlayNowMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlayNowMoviesRepositoryImpl @Inject constructor(
    @PlayNow private val dataSource: DataSource
) : PlayNowMoviesRepository {
    override suspend fun getData(): Flow<List<PlayNowMovieModel>> = flow {
        emit(dataSource.getPlayNowMovies())
    }.catch { e ->
        throw Exception("Erro ao buscar filmes: ${e.message}")
    }
}