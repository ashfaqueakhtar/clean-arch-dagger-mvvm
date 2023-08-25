package com.example.dagger2exmp.presentation.di

import com.example.dagger2exmp.domain.repository.ArtistsRepository
import com.example.dagger2exmp.domain.repository.MoviesRepository
import com.example.dagger2exmp.domain.repository.TvRepository
import com.example.dagger2exmp.domain.usecase.GetArtistsUseCase
import com.example.dagger2exmp.domain.usecase.GetMoviesUseCase
import com.example.dagger2exmp.domain.usecase.GetTvUseCase
import com.example.dagger2exmp.domain.usecase.UpdateArtistsUseCase
import com.example.dagger2exmp.domain.usecase.UpdateMovieUseCase
import com.example.dagger2exmp.domain.usecase.UpdateTvUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(moviesRepository: MoviesRepository): GetMoviesUseCase {
        return GetMoviesUseCase(moviesRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(moviesRepository: MoviesRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(moviesRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistsRepository: ArtistsRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistsRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistsRepository)
    }

    @Provides
    fun provideGetTvUseCase(tvRepository: TvRepository): GetTvUseCase {
        return GetTvUseCase(tvRepository)
    }

    @Provides
    fun provideUpdateTvUseCase(tvRepository: TvRepository): UpdateTvUseCase {
        return UpdateTvUseCase(tvRepository)
    }
}