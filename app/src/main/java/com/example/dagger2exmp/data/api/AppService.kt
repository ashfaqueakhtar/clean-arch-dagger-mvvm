package com.example.dagger2exmp.data.api

import com.example.dagger2exmp.data.model.movie.PopularMovieResponse
import com.example.dagger2exmp.data.model.artist.PopularPersonResponse
import com.example.dagger2exmp.data.model.tv.PopularTvResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<PopularMovieResponse>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<PopularPersonResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<PopularTvResponse>
}