package com.lucassimao.movielanddibbarbosa.feature.news.data.service

import com.lucassimao.movielanddibbarbosa.feature.news.data.model.NewsModel

interface NewsDataSource {
    fun getArticles(): NewsModel
}