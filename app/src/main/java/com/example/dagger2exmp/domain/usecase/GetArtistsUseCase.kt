package com.example.dagger2exmp.domain.usecase

import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.domain.repository.ArtistsRepository

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute():List<Person>? = artistsRepository.getArtists()
}