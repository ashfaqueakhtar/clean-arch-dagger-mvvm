package com.example.dagger2exmp.data.repository.movie.dataSource

import com.example.dagger2exmp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun getMoviesFromCache(): List<Movie>
}