package com.lucassimao.movielanddibbarbosa.core.network

import com.lucassimao.movielanddibbarbosa.BuildConfig
import com.lucassimao.movielanddibbarbosa.core.di.TMDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .header("accept", "application/json")
                .header(
                    "Authorization",
                    "Bearer ${BuildConfig.API_TOKEN_TMDB}"
                )
                .method(original.method, original.body)
            chain.proceed(requestBuilder.build())
        }

        return builder
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @TMDB
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_TMDB)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideMovieApi(@TMDB retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

}