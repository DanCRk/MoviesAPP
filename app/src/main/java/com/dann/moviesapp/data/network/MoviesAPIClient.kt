package com.dann.moviesapp.data.network

import com.dann.moviesapp.data.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesAPIClient {

    @GET("movie/popular?api_key=05f50262a189b7626eb2374affadd77a&sort_by=vote_average.desc&page=1")
    suspend fun getAllPopularMovies():Response<MoviesResponse>

    @GET("movie/now_playing?api_key=05f50262a189b7626eb2374affadd77a&sort_by=vote_average.desc&page=1")
    suspend fun getAllPlayingNowMovies():Response<MoviesResponse>
}