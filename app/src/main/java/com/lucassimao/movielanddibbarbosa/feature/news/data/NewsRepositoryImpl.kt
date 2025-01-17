package com.lucassimao.movielanddibbarbosa.feature.news.data

import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel
import com.lucassimao.movielanddibbarbosa.feature.news.data.service.NewsDataSource
import com.lucassimao.movielanddibbarbosa.feature.news.domain.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val dataSource: NewsDataSource
) : NewsRepository {

    override suspend fun getData(): Flow<List<ArticleModel>> = flow {
        val result = dataSource.getArticles()
        emit(result)
    }
}