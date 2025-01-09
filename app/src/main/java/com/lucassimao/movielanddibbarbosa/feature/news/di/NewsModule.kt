package com.lucassimao.movielanddibbarbosa.feature.news.di

import com.lucassimao.movielanddibbarbosa.feature.news.data.NewsRepositoryImpl
import com.lucassimao.movielanddibbarbosa.feature.news.data.service.NewsDataSource
import com.lucassimao.movielanddibbarbosa.feature.news.data.service.NewsMockData
import com.lucassimao.movielanddibbarbosa.feature.news.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Provides
    fun provideNewsMockDataSource(): NewsDataSource {
        return NewsMockData()
    }

    @Provides
    fun provideNewsRepository(dataSource: NewsDataSource): NewsRepository {
        return NewsRepositoryImpl(dataSource)
    }
}