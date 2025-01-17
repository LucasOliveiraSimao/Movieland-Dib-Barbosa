package com.lucassimao.movielanddibbarbosa.feature.news.data.service

import com.lucassimao.movielanddibbarbosa.BuildConfig
import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel
import com.lucassimao.movielanddibbarbosa.feature.news.di.NewsApi
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsDataSource {

    override suspend fun getArticles(): List<ArticleModel> {
        val response = newsApi.getNewsAboutMovies(
            query = "cinema e filme",
            language = "pt",
            from = "2025-01-15",
            to = "2025-01-15",
            sortBy = "publishedAt",
            apiKey = BuildConfig.API_TOKEN_NEWS
        )

        if (response.isSuccessful) {
            return response.body()!!.articleModels ?: throw Exception("Resposta vazia da API")
        } else {
            throw Exception("Erro da API: ${response.code()} - ${response.message()}")
        }
    }

}