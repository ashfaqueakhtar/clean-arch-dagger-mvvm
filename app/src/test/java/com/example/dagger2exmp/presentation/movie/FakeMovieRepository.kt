package com.example.dagger2exmp.presentation.movie

import com.example.dagger2exmp.data.model.movie.Movie
import com.example.dagger2exmp.domain.repository.MoviesRepository

class FakeMovieRepository : MoviesRepository {
    private val fakeList = mutableListOf<Movie>()

    override suspend fun getMovies(): List<Movie>? {
        return fakeList
    }

    override suspend fun updateMovies(): List<Movie>? {
        return fakeList
    }
}