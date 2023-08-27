package com.example.dagger2exmp.presentation.di.core

import com.example.dagger2exmp.data.db.ArtistsDao
import com.example.dagger2exmp.data.db.MovieDao
import com.example.dagger2exmp.data.db.TvDao
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistCacheDataSource
import com.example.dagger2exmp.data.repository.artists.dataSourceImpl.ArtistCacheDataSourceImpl
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.dagger2exmp.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvCacheDataSource
import com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl.TvCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvCacheDataSource(): TvCacheDataSource {
        return TvCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistsCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}