package com.lucassimao.movielanddibbarbosa.feature.news.di

import com.lucassimao.movielanddibbarbosa.BuildConfig
import com.lucassimao.movielanddibbarbosa.core.di.News
import com.lucassimao.movielanddibbarbosa.feature.news.data.NewsRepositoryImpl
import com.lucassimao.movielanddibbarbosa.feature.news.data.service.NewsDataSource
import com.lucassimao.movielanddibbarbosa.feature.news.data.service.NewsDataSourceImpl
import com.lucassimao.movielanddibbarbosa.feature.news.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Provides
    @News
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideNewsApi(@News retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    fun provideNewsDataSource(newsApi: NewsApi): NewsDataSource {
        return NewsDataSourceImpl(newsApi)
    }

    @Provides
    fun provideNewsRepository(dataSource: NewsDataSource): NewsRepository {
        return NewsRepositoryImpl(dataSource)
    }
}