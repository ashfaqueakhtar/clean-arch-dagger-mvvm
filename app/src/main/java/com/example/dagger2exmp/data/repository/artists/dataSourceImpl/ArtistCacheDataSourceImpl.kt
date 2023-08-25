package com.example.dagger2exmp.data.repository.artists.dataSourceImpl

import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistCacheDataSource


class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Person>()

    override suspend fun getArtistsFromCache(): List<Person> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Person>) {
       artistList.clear()
       artistList = ArrayList(artists)
    }
}