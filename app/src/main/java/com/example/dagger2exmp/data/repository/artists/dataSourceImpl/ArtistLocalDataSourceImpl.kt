package com.example.dagger2exmp.data.repository.artists.dataSourceImpl

import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.data.db.ArtistsDao
import com.example.dagger2exmp.data.model.movie.Movie
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistsDao) :
    ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Person> {
        var data = ArrayList<Person>()
        val deferred = CoroutineScope(Dispatchers.IO).async {
            data = ArrayList(artistDao.getAllArtists())
        }
        deferred.await()
        return data
    }

    override suspend fun saveArtistsToDB(artists: List<Person>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}