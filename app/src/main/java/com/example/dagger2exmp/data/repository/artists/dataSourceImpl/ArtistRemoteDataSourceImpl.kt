package com.example.dagger2exmp.data.repository.artists.dataSourceImpl

import com.example.dagger2exmp.data.api.AppService
import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.data.model.artist.PopularPersonResponse
import com.example.dagger2exmp.data.repository.artists.dataSource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val appService: AppService,
    private val apiKey: String
) : ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<PopularPersonResponse> = appService.getPopularArtists(apiKey)

}

