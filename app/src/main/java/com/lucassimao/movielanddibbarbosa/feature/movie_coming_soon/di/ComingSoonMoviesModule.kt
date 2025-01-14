package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.di

import com.lucassimao.movielanddibbarbosa.core.data.MovieDataSource
import com.lucassimao.movielanddibbarbosa.core.di.ComingSoon
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.ComingSoonMoviesRepositoryImpl
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.service.MockComingSoonMovieDataSource
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.domain.ComingSoonMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ComingSoonMoviesModule {
    @Provides
    @ComingSoon
    fun provideMockComingSoonDataSource(): MovieDataSource {
        return MockComingSoonMovieDataSource()
    }

    @Provides
    fun provideComingSoonMoviesRepository(@ComingSoon movieDataSource: MovieDataSource): ComingSoonMoviesRepository {
        return ComingSoonMoviesRepositoryImpl(movieDataSource)
    }
}