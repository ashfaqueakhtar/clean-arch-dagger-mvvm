package com.example.dagger2exmp.data.repository.movie

import com.example.dagger2exmp.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.dagger2exmp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MoviesRepositoryImplTest {
    @Mock
    lateinit var movieRemoteDataSource: MovieRemoteDataSource

    @Mock
    lateinit var movieLocalDataSource: MovieLocalDataSource

    @Mock
    lateinit var movieCacheDataSource: MovieCacheDataSource

    private lateinit var repo: MoviesRepositoryImpl


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repo =
            MoviesRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Test
    fun testForNull() {
        runBlocking {
            val a = repo.getMovies()
            Truth.assertThat(a).hasSize(0)
        }

    }
}