package com.example.dagger2exmp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.data.model.movie.Movie
import com.example.dagger2exmp.data.model.tv.Tv

@Database(
    entities = [Person::class, Tv::class, Movie::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun artistsDao(): ArtistsDao
    abstract fun tvDao(): TvDao
}