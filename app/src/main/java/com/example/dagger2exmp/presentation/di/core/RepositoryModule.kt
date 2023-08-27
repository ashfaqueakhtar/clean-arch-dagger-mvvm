package com.example.dagger2exmp.presentation.di.core

import com.example.dagger2exmp.data.repository.artists.ArtistRepositoryImpl
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistCacheDataSource
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistLocalDataSource
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistRemoteDatasource
import com.example.dagger2exmp.data.repository.movie.MoviesRepositoryImpl
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.dagger2exmp.data.repository.tvShow.TvRepositoryImpl
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvCacheDataSource
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvLocalDataSource
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvRemoteDataSource
import com.example.dagger2exmp.domain.repository.ArtistsRepository
import com.example.dagger2exmp.domain.repository.MoviesRepository
import com.example.dagger2exmp.domain.repository.TvRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource, artistLocalDataSource, artistCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvRepository(
        tvRemoteDataSource: TvRemoteDataSource,
        tvLocalDataSource: TvLocalDataSource,
        tvCacheDataSource: TvCacheDataSource
    ): TvRepository {
        return TvRepositoryImpl(tvRemoteDataSource, tvLocalDataSource, tvCacheDataSource)
    }
}