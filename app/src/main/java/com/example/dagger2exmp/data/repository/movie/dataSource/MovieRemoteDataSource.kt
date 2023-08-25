package com.example.dagger2exmp.data.repository.movie.dataSource

import com.example.dagger2exmp.data.model.movie.PopularMovieResponse
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<PopularMovieResponse>
}