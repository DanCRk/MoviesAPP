package com.dann.moviesapp.domain

import com.dann.moviesapp.data.Repository
import com.dann.moviesapp.data.database.entities.toDatabase
import com.dann.moviesapp.domain.model.Movie
import javax.inject.Inject

class GetAllPopularMoviesUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(): List<Movie> {

        val movies = repository.getAllPopularMoviesFromApi()

        return if (!movies.isNullOrEmpty()){
            //repository.clearMovies()
            //repository.insertPopularMovies(movies.map { it.toDatabase() })
            movies
        }else{
            //repository.getAllPopularMoviesFromDatabase()
            movies
        }
    }

}