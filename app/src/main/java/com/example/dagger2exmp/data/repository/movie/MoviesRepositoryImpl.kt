package com.example.dagger2exmp.data.repository.movie

import android.util.Log
import com.example.dagger2exmp.data.model.movie.Movie
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.dagger2exmp.domain.repository.MoviesRepository
import java.lang.Exception

class MoviesRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MoviesRepository {
    override suspend fun getMovies(): List<Movie>? {
        return  getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfDta = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(movies = newListOfDta)
        movieCacheDataSource.saveMoviesToCache(newListOfDta)
        return newListOfDta
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                body.movies?.let { movieList = it }
            }
        } catch (e: Exception) {
            Log.d(MoviesRepositoryImpl::class.java.simpleName, "" + e.message.toString())
        }

        return movieList
    }


    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.d(MoviesRepositoryImpl::class.java.simpleName, "" + e.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.d(MoviesRepositoryImpl::class.java.simpleName, "" + e.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}