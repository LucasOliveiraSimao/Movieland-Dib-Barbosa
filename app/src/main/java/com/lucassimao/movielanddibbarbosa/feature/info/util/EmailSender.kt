package com.lucassimao.movielanddibbarbosa.feature.info.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import javax.inject.Inject

class EmailSender @Inject constructor(
    private val context: Context
) {

    fun sendEmailTo(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            context.startActivity(Intent.createChooser(intent, "Escolha o app de e-mail"))
        } catch (e: ActivityNotFoundException) {
            Log.e("EmailSender", "No email app found", e)
        }
    }
}