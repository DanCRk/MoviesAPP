package com.dann.moviesapp.data.model

data class MoviesResponse(
    val results: List<Movie> = emptyList()
)