package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.di

import com.lucassimao.movielanddibbarbosa.core.data.DataSource
import com.lucassimao.movielanddibbarbosa.core.di.PlayNow
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.PlayNowMoviesRepositoryImpl
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.service.MockDataSource
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain.PlayNowMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PlayNowMoviesModule {
    @Provides
    @PlayNow
    fun provideMockDataSource(): DataSource {
        return MockDataSource()
    }

    @Provides
    fun providePlayNowMoviesRepository(@PlayNow dataSource: DataSource): PlayNowMoviesRepository {
        return PlayNowMoviesRepositoryImpl(dataSource)
    }
}