package com.example.dagger2exmp.data.repository.movie.dataSourceImpl

import com.example.dagger2exmp.data.model.movie.Movie
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var charArrayList = ArrayList<Movie>()
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        charArrayList.clear()
        charArrayList = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return charArrayList
    }
}