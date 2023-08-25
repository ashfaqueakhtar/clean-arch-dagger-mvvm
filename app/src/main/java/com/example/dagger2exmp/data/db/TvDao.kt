package com.example.dagger2exmp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dagger2exmp.data.model.tv.Tv

@Dao
interface TvDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTv(tv: List<Tv>)

    @Query(value = "DELETE FROM popular_tv_shows")
    suspend fun deleteAllTv() : Void

    @Query(value = "SELECT * FROM popular_tv_shows")
    suspend fun getAllTv():List<Tv>
}