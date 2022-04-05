package com.dann.moviesapp.domain

import com.dann.moviesapp.data.Repository
import com.dann.moviesapp.data.model.MovieModel
import javax.inject.Inject

class GetAllPlayingNowMoviesUseCase @Inject constructor(private val repository: Repository){

    //suspend operator fun invoke():List<MovieModel> = repository.getAllPlayingNowMoviesFromApi()
}