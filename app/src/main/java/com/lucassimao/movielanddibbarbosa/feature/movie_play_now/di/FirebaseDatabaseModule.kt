package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseDatabaseModule {

    @Provides
    @Singleton
    fun provideFirebaseDatabaseReference(): DatabaseReference =
        FirebaseDatabase.getInstance().reference
}