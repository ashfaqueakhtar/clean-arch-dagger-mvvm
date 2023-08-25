package com.example.dagger2exmp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dagger2exmp.domain.usecase.GetMoviesUseCase
import com.example.dagger2exmp.domain.usecase.UpdateMovieUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) :
    ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}