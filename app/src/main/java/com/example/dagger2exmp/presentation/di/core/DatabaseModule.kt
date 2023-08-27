package com.example.dagger2exmp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.dagger2exmp.data.db.AppDatabase
import com.example.dagger2exmp.data.db.ArtistsDao
import com.example.dagger2exmp.data.db.MovieDao
import com.example.dagger2exmp.data.db.TvDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "dagger_exmp_db")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(appDatabase: AppDatabase): TvDao {
        return appDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistsDao(appDatabase: AppDatabase): ArtistsDao {
        return appDatabase.artistsDao()
    }
}