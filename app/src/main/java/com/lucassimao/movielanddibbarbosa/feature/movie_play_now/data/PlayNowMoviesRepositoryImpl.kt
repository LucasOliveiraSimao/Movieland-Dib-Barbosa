package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data

import com.lucassimao.movielanddibbarbosa.core.CallbackHelper
import com.lucassimao.movielanddibbarbosa.core.data.MovieDataSource
import com.lucassimao.movielanddibbarbosa.core.di.PlayNow
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain.PlayNowMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withTimeout
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PlayNowMoviesRepositoryImpl @Inject constructor(
    @PlayNow private val movieDataSource: MovieDataSource
) : PlayNowMoviesRepository {

    override suspend fun getData(): Flow<List<PlayNowMovieModel>> = flow {
        try {
            val result = withTimeout(5000L) {
                suspendCoroutine { continuation ->
                    movieDataSource.getPlayNowMovies(callbackHelper = object :
                        CallbackHelper<List<PlayNowMovieModel>> {
                        override fun onSuccess(result: List<PlayNowMovieModel>) {
                            continuation.resume(result)
                        }

                        override fun onError(error: String) {
                            continuation.resumeWithException(Exception(error))
                        }
                    })
                }
            }
            emit(result)
        } catch (e: Exception) {
            throw Exception("Erro ao buscar filmes: ${e.message ?: "Tempo limite excedido"}")
        }

    }
}