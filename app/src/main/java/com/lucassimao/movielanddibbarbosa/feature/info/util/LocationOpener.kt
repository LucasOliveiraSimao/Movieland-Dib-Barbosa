package com.lucassimao.movielanddibbarbosa.feature.info.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class LocationOpener @Inject constructor(
    private val context: Context
) {

    fun openLocationInMaps(latitude: Double, longitude: Double, label: String?) {
        // Validate input parameters
        require(latitude >= -90.0 && latitude <= 90.0) { "Latitude must be between -90 and 90 degrees." }
        require(longitude >= -180.0 && longitude <= 180.0) { "Longitude must be between -180 and 180 degrees." }

        // Build the URI for the Google Maps intent
        val gmmIntentUri = buildGoogleMapsUri(latitude, longitude, label!!)

        // Create the intent to open Google Maps
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
            `package` = "com.google.android.apps.maps"
        }

        try {
            context.startActivity(mapIntent)
        } catch (e: ActivityNotFoundException) {
            // If Google Maps is not available, open the location in a web browser
            val browserIntent = buildBrowserIntent(latitude, longitude)
            context.startActivity(browserIntent)
        }
    }

    private fun buildGoogleMapsUri(latitude: Double, longitude: Double, label: String): Uri {
        // Validate input parameters
        require(latitude >= -90.0 && latitude <= 90.0) { "Latitude must be between -90 and 90 degrees." }
        require(longitude >= -180.0 && longitude <= 180.0) { "Longitude must be between -180 and 180 degrees." }

        // Build the URI for the Google Maps intent
        val gmmIntentUri = if (label.isNotEmpty()) {
            // If the label is not empty, build the URI for the Google Maps intent
            "geo:$latitude,$longitude?q=$latitude,$longitude&label=$label"
        } else {
            // If the label is empty, build the URI for the Google Maps intent
            "geo:$latitude,$longitude?q=$latitude,$longitude"
        }
        return Uri.parse(gmmIntentUri)
    }

    private fun buildBrowserIntent(latitude: Double, longitude: Double): Intent {
        // Validate input parameters
        require(latitude >= -90.0 && latitude <= 90.0) { "Latitude must be between -90 and 90 degrees." }
        require(longitude >= -180.0 && longitude <= 180.0) { "Longitude must be between -180 and 180 degrees." }

        // Build the URI for the web browser intent
        val browserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.google.com/maps/search/?api=1&query=$latitude,$longitude")
        )
        return browserIntent
    }
}