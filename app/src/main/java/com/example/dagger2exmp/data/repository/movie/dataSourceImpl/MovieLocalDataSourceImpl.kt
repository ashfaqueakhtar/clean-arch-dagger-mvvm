package com.example.dagger2exmp.data.repository.movie.dataSourceImpl

import com.example.dagger2exmp.data.db.MovieDao
import com.example.dagger2exmp.data.model.movie.Movie
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        var data = ArrayList<Movie>()
        val deferred = CoroutineScope(Dispatchers.IO).async {
            data = ArrayList(movieDao.getAllMovies())
        }
        deferred.await();

        return data
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}