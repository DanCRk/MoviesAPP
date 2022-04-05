package com.dann.moviesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dann.moviesapp.data.model.MovieModel
import com.dann.moviesapp.domain.GetAllPopularMoviesUseCase
import com.dann.moviesapp.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPopularMoviesUseCase: GetAllPopularMoviesUseCase,
):ViewModel(){
    val movies = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllPopularMoviesUseCase()
            if (!result.isNullOrEmpty()){
                movies.postValue(result)
                isLoading.postValue(false)
            }

        }
    }
}