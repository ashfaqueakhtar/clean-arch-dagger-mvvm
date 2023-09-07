package com.example.dagger2exmp.domain.usecase

import com.example.dagger2exmp.domain.repository.MoviesRepository
import com.example.dagger2exmp.data.model.movie.Movie

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(): List<Movie>? = moviesRepository.getMovies()
}