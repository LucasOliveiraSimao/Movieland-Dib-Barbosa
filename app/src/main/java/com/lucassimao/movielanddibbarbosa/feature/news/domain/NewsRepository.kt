package com.lucassimao.movielanddibbarbosa.feature.news.domain

import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getData(): Flow<List<ArticleModel?>>
}