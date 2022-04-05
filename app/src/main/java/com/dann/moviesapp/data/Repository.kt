package com.dann.moviesapp.data

import com.dann.moviesapp.data.database.dao.MoviesDao
import com.dann.moviesapp.data.database.entities.MovieEntity
import com.dann.moviesapp.data.network.MoviesService
import com.dann.moviesapp.domain.model.Movie
import com.dann.moviesapp.domain.model.toDomain
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: MoviesService,
    private val moviesDao:MoviesDao
) {

    suspend fun getAllPopularMoviesFromApi(): List<Movie> {
        val response = api.getPopularMovies()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPopularMoviesFromDatabase(): List<Movie> {
        val response = moviesDao.getAllPopularMovies()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPlayingNowMoviesFromApi(): List<Movie> {
        val response = api.getPlayingNowMovies()
        return response.map { it.toDomain() }
    }

    suspend fun insertPopularMovies(movies: List<MovieEntity>){
        moviesDao.insertAllPopularMovies(movies)
    }

    suspend fun clearMovies() {
        moviesDao.deleteAllMovies()
    }
}