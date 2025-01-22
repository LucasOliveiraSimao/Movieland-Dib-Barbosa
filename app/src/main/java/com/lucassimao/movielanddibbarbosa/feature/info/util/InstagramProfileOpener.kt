package com.lucassimao.movielanddibbarbosa.feature.info.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class InstagramProfileOpener @Inject constructor(
    private val context: Context

) {

    fun openInstagramProfile(instagramUsername: String) {
        val instagramIntent = createInstagramIntent(instagramUsername)
        try {
            context.startActivity(instagramIntent)
        } catch (e: ActivityNotFoundException) {
            openInstagramInBrowser(instagramUsername)
        }
    }

    private fun createInstagramIntent(instagramUsername: String): Intent {
        val uri = Uri.parse("https://www.instagram.com/_u/$instagramUsername")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        intent.setPackage("com.instagram.android")
        return intent
    }

    private fun openInstagramInBrowser(instagramUsername: String) {
        val browserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.instagram.com/$instagramUsername/")
        )
        context.startActivity(browserIntent)
    }

}