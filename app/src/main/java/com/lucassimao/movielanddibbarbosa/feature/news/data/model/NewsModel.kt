package com.lucassimao.movielanddibbarbosa.feature.news.data.model

data class NewsModel(
    val articleModels: List<ArticleModel>,
    val status: String?,
    val totalResults: Int?
)