package com.lucassimao.movielanddibbarbosa.core.network

import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMoviesResult
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("movie/upcoming?language=pt-BR&page=1")
    suspend fun getComingSoonMovies(): Response<ComingSoonMoviesResult>
}