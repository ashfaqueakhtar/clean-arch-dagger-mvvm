package com.example.dagger2exmp.domain.repository

import com.example.dagger2exmp.data.model.movie.Movie

interface MoviesRepository {
    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies():List<Movie>?
}