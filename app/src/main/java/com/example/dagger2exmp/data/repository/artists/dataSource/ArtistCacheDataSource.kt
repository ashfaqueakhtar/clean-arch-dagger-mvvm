package com.example.dagger2exmp.data.repository.artists.dataSource

import com.example.dagger2exmp.data.model.artist.Person

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Person>
    suspend fun saveArtistsToCache(artists:List<Person>)

}