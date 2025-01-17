package com.lucassimao.movielanddibbarbosa.feature.news.data.service

import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel

interface NewsDataSource {
    suspend fun getArticles(): List<ArticleModel>
}