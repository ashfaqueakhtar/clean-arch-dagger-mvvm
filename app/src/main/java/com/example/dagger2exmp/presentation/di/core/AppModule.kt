package com.example.dagger2exmp.presentation.di.core

import android.content.Context
import com.example.dagger2exmp.presentation.di.artist.ArtistSubComponent
import com.example.dagger2exmp.presentation.di.movie.MovieSubComponent
import com.example.dagger2exmp.presentation.di.tvShow.TvSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,ArtistSubComponent::class, TvSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}