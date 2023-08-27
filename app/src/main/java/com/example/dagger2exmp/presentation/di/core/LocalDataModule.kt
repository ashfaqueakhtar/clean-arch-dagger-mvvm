package com.example.dagger2exmp.presentation.di.core

import com.example.dagger2exmp.data.db.ArtistsDao
import com.example.dagger2exmp.data.db.MovieDao
import com.example.dagger2exmp.data.db.TvDao
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistLocalDataSource
import com.example.dagger2exmp.data.repository.artists.dataSourceImpl.ArtistLocalDataSourceImpl
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.dagger2exmp.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvLocalDataSource
import com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl.TvLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvDao: TvDao): TvLocalDataSource {
        return TvLocalDataSourceImpl(tvDao)
    }

    @Singleton
    @Provides
    fun provideArtistsLocalDataSource(artistsDao: ArtistsDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistsDao)
    }
}