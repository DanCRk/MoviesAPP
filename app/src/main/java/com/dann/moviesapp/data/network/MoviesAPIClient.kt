package com.dann.moviesapp.data.network

import com.dann.moviesapp.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MoviesAPIClient {

    @GET
    suspend fun getAllMovies():Response<List<Movie>>
}