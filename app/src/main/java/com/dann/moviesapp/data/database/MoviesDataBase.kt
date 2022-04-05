package com.dann.moviesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dann.moviesapp.data.database.dao.MoviesDao
import com.dann.moviesapp.data.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MoviesDataBase: RoomDatabase() {

    abstract fun getMoviesDao():MoviesDao
}