package com.example.dagger2exmp.data.repository.tvShow.dataSource

import com.example.dagger2exmp.data.model.tv.PopularTvResponse
import retrofit2.Response

interface TvRemoteDataSource {
    suspend fun getTvShows() : Response<PopularTvResponse>
}