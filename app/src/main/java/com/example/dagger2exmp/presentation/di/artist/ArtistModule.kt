package com.example.dagger2exmp.presentation.di.artist

import com.example.dagger2exmp.domain.usecase.GetArtistsUseCase
import com.example.dagger2exmp.domain.usecase.UpdateArtistsUseCase
import com.example.dagger2exmp.presentation.artists.ArtistViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule(
) {
    @ArtistScope
    @Provides
    fun provideArtistsViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}