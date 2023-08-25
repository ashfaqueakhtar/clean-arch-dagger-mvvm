package com.example.dagger2exmp.data.repository.artists.dataSource

import com.example.dagger2exmp.data.model.artist.PopularPersonResponse
import retrofit2.Response

interface ArtistRemoteDatasource {
   suspend fun getArtists(): Response<PopularPersonResponse>
}