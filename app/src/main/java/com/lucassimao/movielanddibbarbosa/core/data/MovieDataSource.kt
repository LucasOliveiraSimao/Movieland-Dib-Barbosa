package com.lucassimao.movielanddibbarbosa.core.data

import com.lucassimao.movielanddibbarbosa.core.CallbackHelper
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel

interface MovieDataSource {
    fun getPlayNowMovies(callbackHelper: CallbackHelper<List<PlayNowMovieModel>>){
        throw UnsupportedOperationException()
    }

    suspend fun getComingSoonMovies(): List<ComingSoonMovieModel> {
        throw UnsupportedOperationException()
    }
}