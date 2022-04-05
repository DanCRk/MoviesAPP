package com.dann.moviesapp.domain.model

import com.dann.moviesapp.data.database.entities.MovieEntity
import com.dann.moviesapp.data.model.MovieModel
import java.io.Serializable

data class Movie(
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
) : Serializable

fun MovieModel.toDomain() = Movie(
    adult,
    backdrop_path,
    original_language,
    original_title,
    overview,
    popularity,
    poster_path,
    release_date,
    title,
    video,
    vote_average,
    vote_count
)

fun MovieEntity.toDomain() = Movie(
    adult,
    backdrop_path,
    original_language,
    original_title,
    overview,
    popularity,
    poster_path,
    release_date,
    title,
    video,
    vote_average,
    vote_count
)