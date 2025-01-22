package com.lucassimao.movielanddibbarbosa.feature.info.di

import android.app.Activity
import com.lucassimao.movielanddibbarbosa.feature.info.util.EmailSender
import com.lucassimao.movielanddibbarbosa.feature.info.util.InstagramProfileOpener
import com.lucassimao.movielanddibbarbosa.feature.info.util.LocationOpener
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object InfoModule {

    @Provides
    @ActivityScoped
    fun provideEmailSender(activity: Activity): EmailSender {
        return EmailSender(activity)
    }

    @Provides
    @ActivityScoped
    fun provideInstagramProfileOpener(activity: Activity): InstagramProfileOpener {
        return InstagramProfileOpener(activity)
    }

    @Provides
    @ActivityScoped
    fun provideLocationOpener(activity: Activity): LocationOpener {
        return LocationOpener(activity)
    }
}