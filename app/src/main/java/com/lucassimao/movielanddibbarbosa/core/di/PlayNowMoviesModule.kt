package com.lucassimao.movielanddibbarbosa.core.di

import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.PlayNowMoviesRepositoryImpl
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.service.DataSource
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.service.MockDataSource
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PlayNowMoviesModule {
    @Provides
    fun provideMockDataSource(): DataSource {
        return MockDataSource()
    }

    @Provides
    fun provideRepository(dataSource: DataSource): Repository {
        return PlayNowMoviesRepositoryImpl(dataSource)
    }
}