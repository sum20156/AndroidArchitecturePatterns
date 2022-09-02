package com.example.architecturepatterns.models.network

import com.example.architecturepatterns.models.domain.Movie

data class MovieResponse(
    val errorMessage: String,
    val items: List<MovieResponseItem>
)

data class MovieResponseItem(
    val crew: String,
    val fullTitle: String,
    val id: String,
    val imDbRating: String,
    val imDbRatingCount: String,
    val image: String,
    val rank: String,
    val title: String,
    val year: String
)

fun List<MovieResponseItem>.asDomainModel(): List<Movie> {
    return map {
        Movie(
            title = it.title,
            thumbnail = it.image,
            rating = it.imDbRating
        )
    }
}