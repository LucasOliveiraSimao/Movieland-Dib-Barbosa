package com.lucassimao.movielanddibbarbosa.feature.news.data.model

import com.google.gson.annotations.SerializedName
import com.lucassimao.movielanddibbarbosa.core.data.DiffItem

data class ArticleModel(
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?
) : DiffItem<ArticleModel> {

    override fun areItemsTheSame(other: ArticleModel): Boolean {
        return title == other.title
    }

    override fun areContentsTheSame(other: ArticleModel): Boolean {
        return this == other
    }
}