package com.lucassimao.movielanddibbarbosa.feature.news.data.model

import com.lucassimao.movielanddibbarbosa.core.data.DiffItem

data class ArticleModel(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : DiffItem<ArticleModel> {
    override fun areItemsTheSame(other: ArticleModel): Boolean {
        return title == other.title
    }

    override fun areContentsTheSame(other: ArticleModel): Boolean {
        return this == other
    }
}