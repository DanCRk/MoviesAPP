package com.dann.moviesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dann.moviesapp.data.model.Movie
import com.dann.moviesapp.domain.GetAllMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
):ViewModel(){
    val movies = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllMoviesUseCase()
            if (!result.isNullOrEmpty()){
                movies.postValue(result)
                isLoading.postValue(false)
            }

        }
    }
}