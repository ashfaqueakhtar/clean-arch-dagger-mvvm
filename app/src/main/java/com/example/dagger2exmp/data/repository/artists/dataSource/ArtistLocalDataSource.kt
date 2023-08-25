package com.example.dagger2exmp.data.repository.artists.dataSource

import com.example.dagger2exmp.data.model.artist.Person

interface ArtistLocalDataSource {
  suspend fun getArtistsFromDB():List<Person>
  suspend fun saveArtistsToDB(artists:List<Person>)
  suspend fun clearAll()
}