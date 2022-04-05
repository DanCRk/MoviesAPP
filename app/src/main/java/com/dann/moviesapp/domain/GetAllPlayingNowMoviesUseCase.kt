package com.dann.moviesapp.domain

import com.dann.moviesapp.data.Repository
import com.dann.moviesapp.domain.model.Movie
import javax.inject.Inject

class GetAllPlayingNowMoviesUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke():List<Movie> = repository.getAllPlayingNowMoviesFromApi()
}