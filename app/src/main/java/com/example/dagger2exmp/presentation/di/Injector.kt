package com.example.dagger2exmp.presentation.di

import com.example.dagger2exmp.presentation.di.artist.ArtistSubComponent
import com.example.dagger2exmp.presentation.di.movie.MovieSubComponent
import com.example.dagger2exmp.presentation.di.tvShow.TvSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}