package com.dann.moviesapp.data.network

import com.dann.moviesapp.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesService @Inject constructor(private val api: MoviesAPIClient) {

    suspend fun getPopularMovies():List<Movie>{
        return withContext(Dispatchers.IO){
            val response = api.getAllPopularMovies().body()
            response?.results ?: emptyList()
        }
    }

    suspend fun getPlayingNowMovies():List<Movie>{
        return withContext(Dispatchers.IO){
            val response = api.getAllPlayingNowMovies().body()
            response?.results ?: emptyList()
        }
    }

}