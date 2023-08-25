package com.example.dagger2exmp.data.repository.tvShow.dataSource

import com.example.dagger2exmp.data.model.tv.Tv

interface TvLocalDataSource {
    suspend fun getTvShowFromDB() : List<Tv>
    suspend fun saveTvShowToDB(tv: List<Tv>)
    suspend fun clearAll()
}