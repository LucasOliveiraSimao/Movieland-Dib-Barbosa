package com.lucassimao.movielanddibbarbosa.feature.news.di

import com.lucassimao.movielanddibbarbosa.feature.news.data.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    //    @GET("everything?q=cinema e filme&language=pt&from=2025-01-06&to=2025-01-06&sortBy=publishedAt&apiKey=fb3b3ba67ab14ce8b13aa2d4bf6e0303")
    @GET("everything")
    suspend fun getNewsAboutMovies(
        @Query("q") query: String,
        @Query("language") language: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsModel>
}