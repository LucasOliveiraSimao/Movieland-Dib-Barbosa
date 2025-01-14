package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data

import com.lucassimao.movielanddibbarbosa.core.data.MovieDataSource
import com.lucassimao.movielanddibbarbosa.core.di.ComingSoon
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.domain.ComingSoonMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ComingSoonMoviesRepositoryImpl @Inject constructor(
    @ComingSoon private val movieDataSource: MovieDataSource
) : ComingSoonMoviesRepository {
    override suspend fun getData(): Flow<List<ComingSoonMovieModel>> = flow {
        emit(movieDataSource.getComingSoonMovies())
    }.catch { e ->
        throw Exception("Erro ao buscar filmes: ${e.message}")
    }
}