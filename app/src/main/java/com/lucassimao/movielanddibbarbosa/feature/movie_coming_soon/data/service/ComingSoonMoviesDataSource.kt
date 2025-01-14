package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.service

import com.lucassimao.movielanddibbarbosa.core.data.MovieDataSource
import com.lucassimao.movielanddibbarbosa.core.network.MovieApi
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel
import javax.inject.Inject

class ComingSoonMoviesDataSource @Inject constructor(
    private val movieApi: MovieApi
) : MovieDataSource {

    override suspend fun getComingSoonMovies(): List<ComingSoonMovieModel> {
        val response = movieApi.getComingSoonMovies()
        if (response.isSuccessful) {
            return response.body()!!.results ?: throw Exception("Resposta vazia da API")
        } else {
            throw Exception("Erro da API: ${response.code()} - ${response.message()}")
        }
    }
}