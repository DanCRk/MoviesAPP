package com.dann.moviesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dann.moviesapp.data.database.entities.MovieEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_table")
    suspend fun getAllPopularMovies():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPopularMovies(movies:List<MovieEntity>)

    @Query("DELETE FROM movies_table")
    suspend fun deleteAllMovies()

}