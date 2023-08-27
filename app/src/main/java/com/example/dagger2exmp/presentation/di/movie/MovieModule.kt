package com.example.dagger2exmp.presentation.di.movie

import com.example.dagger2exmp.domain.usecase.GetMoviesUseCase
import com.example.dagger2exmp.domain.usecase.UpdateMovieUseCase
import com.example.dagger2exmp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule(
) {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}