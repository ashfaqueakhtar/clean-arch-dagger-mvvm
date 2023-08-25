package com.example.dagger2exmp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dagger2exmp.data.model.artist.Person

@Dao
interface ArtistsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Person>)

    @Query(value = "DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query(value = "SELECT * FROM popular_artists")
    suspend fun getAllArtists(): List<Person>
}