package com.lucassimao.movielanddibbarbosa.feature.news.data.model

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?,
    @SerializedName("articles")
    val articleModels: List<ArticleModel>
)