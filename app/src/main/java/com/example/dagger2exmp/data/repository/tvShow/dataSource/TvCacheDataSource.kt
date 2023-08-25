package com.example.dagger2exmp.data.repository.tvShow.dataSource

import com.example.dagger2exmp.data.model.tv.Tv

interface TvCacheDataSource {
    suspend fun saveTvShowToCache(movies: List<Tv>)
    suspend fun getTvShowFromCache(): List<Tv>
}