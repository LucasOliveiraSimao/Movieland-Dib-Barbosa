package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model


import com.google.gson.annotations.SerializedName

data class ComingSoonMoviesResult(
    @SerializedName("dates")
    val datesMovieModel: DatesMovieModel?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<ComingSoonMovieModel>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)