package com.example.dagger2exmp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dagger2exmp.data.model.movie.Movie


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query(value = "DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query(value = "SELECT * FROM popular_movies")
    fun getAllMovies():List<Movie>

    @Query(value = "SELECT * FROM popular_movies")
    fun getAllMovies2():LiveData<List<Movie>>
}