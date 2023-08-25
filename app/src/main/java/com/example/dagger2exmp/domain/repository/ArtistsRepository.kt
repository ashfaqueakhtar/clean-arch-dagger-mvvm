package com.example.dagger2exmp.domain.repository

import com.example.dagger2exmp.data.model.artist.Person

interface ArtistsRepository {
    suspend fun getArtists(): List<Person>?

    suspend fun updateArtists():List<Person>?
}