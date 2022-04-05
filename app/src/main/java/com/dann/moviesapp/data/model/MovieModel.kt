package com.dann.moviesapp.data.model


data class MovieModel(
    val adult: Boolean = false,
    val backdrop_path: String = "_",
    val original_language: String = "_",
    val original_title: String = "_",
    val overview: String = "_",
    val popularity: Double = 0.0,
    val poster_path: String = "_",
    val release_date: String = "_",
    val title: String = "_",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)