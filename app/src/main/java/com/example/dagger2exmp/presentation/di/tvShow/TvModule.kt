package com.example.dagger2exmp.presentation.di.tvShow

import com.example.dagger2exmp.domain.usecase.GetTvUseCase
import com.example.dagger2exmp.presentation.tvShows.TvViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvModule(
) {
    @TvScope
    @Provides
    fun provideTvViewModelFactory(
        getTvUseCase: GetTvUseCase,
        updateTvUseCase: GetTvUseCase
    ): TvViewModelFactory {
        return TvViewModelFactory(getTvUseCase, updateTvUseCase)
    }
}