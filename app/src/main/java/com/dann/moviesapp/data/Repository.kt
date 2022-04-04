package com.dann.moviesapp.data

import com.dann.moviesapp.data.model.Movie
import com.dann.moviesapp.data.network.MoviesService
import javax.inject.Inject

class Repository @Inject constructor(private val api:MoviesService){

    suspend fun getAllPopularMovies(): List<Movie> {
        return api.getPopularMovies()
    }

    suspend fun getAllPlayingNowMovies(): List<Movie> {
        return api.getPlayingNowMovies()
    }
}