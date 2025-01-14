package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model


import com.google.gson.annotations.SerializedName

data class DatesMovieModel(
    @SerializedName("maximum")
    val maximum: String?,
    @SerializedName("minimum")
    val minimum: String?
)