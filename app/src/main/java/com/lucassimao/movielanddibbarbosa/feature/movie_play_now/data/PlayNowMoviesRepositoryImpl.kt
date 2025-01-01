package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data

import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMoviesModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.service.DataSource
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlayNowMoviesRepositoryImpl @Inject constructor(
    private val dataSource: DataSource
) : Repository {
    override suspend fun getData(): Flow<PlayNowMoviesModel> = flow {
        emit(dataSource.getPlayNowMovies())
    }.catch { e ->
        throw Exception("Erro ao buscar filmes: ${e.message}")
    }
}