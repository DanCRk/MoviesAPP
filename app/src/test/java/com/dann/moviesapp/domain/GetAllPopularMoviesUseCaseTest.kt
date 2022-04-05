package com.dann.moviesapp.domain

import com.dann.moviesapp.data.Repository
import com.dann.moviesapp.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllPopularMoviesUseCaseTest{

    @RelaxedMockK
    private lateinit var repository: Repository

    lateinit var getAllPopularMoviesUseCase: GetAllPopularMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getAllPopularMoviesUseCase = GetAllPopularMoviesUseCase(repository)
    }

    @Test
    fun `when the api returns something then get values from api`() = runBlocking {
        //Given
        val myList = listOf(Movie())
        coEvery { repository.getAllPopularMoviesFromApi() } returns myList

        //When
        val response = getAllPopularMoviesUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllPopularMoviesFromApi() }
        coVerify(exactly = 0) { repository.getAllPopularMoviesFromDatabase() }
        assert(response == myList)
    }

    @Test
    fun `when the api returns an empty list then get values from api`() = runBlocking {
        //Given
        val myList = emptyList<Movie>()
        coEvery { repository.getAllPopularMoviesFromApi() } returns myList

        //When
        val response = getAllPopularMoviesUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllPopularMoviesFromApi() }
        coVerify(exactly = 0) { repository.getAllPopularMoviesFromDatabase() }
        assert(response == myList)
    }
}