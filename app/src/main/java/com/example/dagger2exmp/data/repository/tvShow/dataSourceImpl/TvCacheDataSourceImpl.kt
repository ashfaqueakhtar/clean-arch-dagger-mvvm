package com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl

import com.example.dagger2exmp.data.model.tv.Tv
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvCacheDataSource

class TvCacheDataSourceImpl : TvCacheDataSource {
    private var charArrayList = ArrayList<Tv>()
    override suspend fun saveTvShowToCache(movies: List<Tv>) {
        charArrayList.clear()
        charArrayList = ArrayList(charArrayList)
    }

    override suspend fun getTvShowFromCache(): List<Tv> {
        return charArrayList
    }
}