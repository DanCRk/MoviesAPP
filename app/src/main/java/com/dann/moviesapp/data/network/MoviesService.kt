package com.dann.moviesapp.data.network

import com.dann.moviesapp.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesService @Inject constructor(private val api: MoviesAPIClient) {

    suspend fun getMovies():List<Movie>{
        return withContext(Dispatchers.IO){
            val response = api.getAllMovies().body()
            response?.results ?: emptyList()
        }
    }

}