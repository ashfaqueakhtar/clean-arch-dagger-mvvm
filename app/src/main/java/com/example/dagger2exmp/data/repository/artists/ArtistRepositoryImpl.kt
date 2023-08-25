package com.example.dagger2exmp.data.repository.artists


import android.util.Log
import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistCacheDataSource
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistLocalDataSource
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistRemoteDatasource
import com.example.dagger2exmp.domain.repository.ArtistsRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistsRepository {
    override suspend fun getArtists(): List<Person>? {
        Log.i("ARTTAG", "artist repository impl getArtists")
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Person>? {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistsFromAPI(): List<Person> {
        lateinit var artistList: List<Person>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                body.people?.let { artistList = it }
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Person> {
        lateinit var artistList: List<Person>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Person> {
        lateinit var artistList: List<Person>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }


}