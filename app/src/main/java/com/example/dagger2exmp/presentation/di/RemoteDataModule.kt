package com.example.dagger2exmp.presentation.di

import com.example.dagger2exmp.data.api.AppService
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistRemoteDatasource
import com.example.dagger2exmp.data.repository.artists.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.dagger2exmp.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvRemoteDataSource
import com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl.TvCacheDataSourceImpl
import com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl.TvRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(appService: AppService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(appService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(appService: AppService): TvRemoteDataSource {
        return TvRemoteDataSourceImpl(appService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistsRemoteDataSource(appService: AppService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(appService, apiKey)
    }
}