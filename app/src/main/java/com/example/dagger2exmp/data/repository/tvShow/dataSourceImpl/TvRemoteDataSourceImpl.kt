package com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl

import com.example.dagger2exmp.data.api.AppService
import com.example.dagger2exmp.data.model.tv.PopularTvResponse
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvRemoteDataSource
import retrofit2.Response

class TvRemoteDataSourceImpl(private val appService: AppService, private val apiKey: String) :
    TvRemoteDataSource {
    override suspend fun getTvShows(): Response<PopularTvResponse> =
        appService.getPopularTvShows(apiKey)
}