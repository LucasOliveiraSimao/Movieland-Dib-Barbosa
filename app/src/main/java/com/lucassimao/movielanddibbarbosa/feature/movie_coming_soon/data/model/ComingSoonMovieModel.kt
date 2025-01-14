package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model


import com.google.gson.annotations.SerializedName
import com.lucassimao.movielanddibbarbosa.core.data.DiffItem

data class ComingSoonMovieModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
) : DiffItem<ComingSoonMovieModel> {
    override fun areItemsTheSame(other: ComingSoonMovieModel): Boolean {
        return id == other.id
    }

    override fun areContentsTheSame(other: ComingSoonMovieModel): Boolean {
        return this == other
    }
}