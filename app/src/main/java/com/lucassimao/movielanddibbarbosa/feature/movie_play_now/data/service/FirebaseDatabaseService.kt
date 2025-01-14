package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.service

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.lucassimao.movielanddibbarbosa.core.CallbackHelper
import com.lucassimao.movielanddibbarbosa.core.Constants
import com.lucassimao.movielanddibbarbosa.core.data.MovieDataSource
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel
import javax.inject.Inject

class FirebaseDatabaseService @Inject constructor(
    private val database: DatabaseReference
) : MovieDataSource {

    override fun getPlayNowMovies(callbackHelper: CallbackHelper<List<PlayNowMovieModel>>) {
        database.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val movies = snapshot.child(Constants.MOVIES).children.mapNotNull { movie ->
                        movie.getValue(PlayNowMovieModel::class.java)
                    }
                    callbackHelper.onSuccess(movies)
                } else {
                    callbackHelper.onSuccess(emptyList())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callbackHelper.onError(error.message)
            }
        })
    }

}