package com.example.dagger2exmp.data.repository.movie.dataSource

import com.example.dagger2exmp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}