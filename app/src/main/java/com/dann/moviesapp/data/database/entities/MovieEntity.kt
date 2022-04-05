package com.dann.moviesapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dann.moviesapp.domain.model.Movie

@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "adult") val adult: Boolean = false,
    @ColumnInfo(name = "backdrop_path") val backdrop_path: String = "_",
    @ColumnInfo(name = "original_language") val original_language: String = "_",
    @ColumnInfo(name = "original_title") val original_title: String = "_",
    @ColumnInfo(name = "overview") val overview: String = "_",
    @ColumnInfo(name = "popularity") val popularity: Double = 0.0,
    @ColumnInfo(name = "poster_path") val poster_path: String = "_",
    @ColumnInfo(name = "release_date") val release_date: String = "_",
    @ColumnInfo(name = "title") val title: String = "_",
    @ColumnInfo(name = "video") val video: Boolean = false,
    @ColumnInfo(name = "vote_average") val vote_average: Double = 0.0,
    @ColumnInfo(name = "vote_count") val vote_count: Int = 0
)

fun Movie.toDatabase() = MovieEntity(
    adult = adult,
    backdrop_path = backdrop_path,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count
)