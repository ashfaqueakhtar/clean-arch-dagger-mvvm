package com.example.dagger2exmp.data.repository.movie.dataSourceImpl

import com.example.dagger2exmp.data.api.AppService
import com.example.dagger2exmp.data.model.movie.PopularMovieResponse
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val appService: AppService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<PopularMovieResponse> =
        appService.getPopularMovies(apiKey)
}