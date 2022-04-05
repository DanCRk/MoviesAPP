package com.dann.moviesapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dann.moviesapp.domain.GetAllPopularMoviesUseCase
import com.dann.moviesapp.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @RelaxedMockK
    private lateinit var getAllPopularMoviesUseCase: GetAllPopularMoviesUseCase

    private lateinit var moviesViewModel: HomeViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        moviesViewModel = HomeViewModel(getAllPopularMoviesUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at the first time, get all movies`() = runTest {
        //Given
        val movies = listOf(Movie())
        coEvery { getAllPopularMoviesUseCase() } returns movies

        //When
        moviesViewModel.onCreate()

        //Then
        assert(moviesViewModel.movies.value == movies)
    }

}