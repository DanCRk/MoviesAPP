package com.dann.moviesapp.domain

import com.dann.moviesapp.data.Repository
import com.dann.moviesapp.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllPlayingNowMoviesUseCaseTest(){

    @RelaxedMockK
    private lateinit var repository: Repository

    lateinit var getAllPlayingNowMoviesUseCase: GetAllPlayingNowMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getAllPlayingNowMoviesUseCase = GetAllPlayingNowMoviesUseCase(repository)
    }

    @Test
    fun `when the api returns something then get values from api`() = runBlocking {
        //Given
        val myList = listOf(Movie())
        coEvery { repository.getAllPlayingNowMoviesFromApi() } returns myList

        //When
        val response = getAllPlayingNowMoviesUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllPlayingNowMoviesFromApi() }
        coVerify(exactly = 0) { repository.getAllPopularMoviesFromDatabase() }
        coVerify(exactly = 0) { repository.getAllPopularMoviesFromApi() }
        assert(response == myList)
    }
}