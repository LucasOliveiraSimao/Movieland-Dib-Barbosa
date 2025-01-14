package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.di

import com.google.firebase.database.DatabaseReference
import com.lucassimao.movielanddibbarbosa.core.data.MovieDataSource
import com.lucassimao.movielanddibbarbosa.core.di.PlayNow
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.PlayNowMoviesRepositoryImpl
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.service.FirebaseDatabaseService
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
    fun provideFirebaseService(database: DatabaseReference): MovieDataSource {
        return FirebaseDatabaseService(database)
    }

    @Provides
    fun providePlayNowMoviesRepository(@PlayNow movieDataSource: MovieDataSource): PlayNowMoviesRepository {
        return PlayNowMoviesRepositoryImpl(movieDataSource)
    }
}