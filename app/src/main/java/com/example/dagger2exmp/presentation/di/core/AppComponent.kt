package com.example.dagger2exmp.presentation.di.core

import com.example.dagger2exmp.presentation.di.artist.ArtistSubComponent
import com.example.dagger2exmp.presentation.di.movie.MovieSubComponent
import com.example.dagger2exmp.presentation.di.tvShow.TvSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetModule::class,
        AppModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent(): TvSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}