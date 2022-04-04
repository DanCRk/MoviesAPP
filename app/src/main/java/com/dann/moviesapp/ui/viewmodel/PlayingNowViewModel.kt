package com.dann.moviesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dann.moviesapp.data.model.Movie
import com.dann.moviesapp.domain.GetAllPlayingNowMoviesUseCase
import com.dann.moviesapp.domain.GetAllPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlayingNowViewModel @Inject constructor(
    private val getAllPlayingNowMoviesUseCase: GetAllPlayingNowMoviesUseCase,
):ViewModel(){
    val movies = MutableLiveData<List<Movie>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllPlayingNowMoviesUseCase()
            if (!result.isNullOrEmpty()){
                movies.postValue(result)
                isLoading.postValue(false)
            }

        }
    }
}