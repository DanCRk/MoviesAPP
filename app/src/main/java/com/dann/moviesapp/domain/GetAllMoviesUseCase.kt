package com.dann.moviesapp.domain

import com.dann.moviesapp.data.Repository
import com.dann.moviesapp.data.model.Movie
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke():List<Movie> = repository.getAllMovies()
}