package com.example.dagger2exmp.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.example.dagger2exmp.data.model.movie.Movie
import com.example.dagger2exmp.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
@SmallTest //It tell that its a unit test
class MovieDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var movieDao: MovieDao

    @Before
    fun setUp() {
        /*inMemoryDatabaseBuilder -> 1. denotes its not real database
        * 2. it will only hold database in RAM not in Persistence storage*/
        /*allowMainThreadQueries -> 1. allows room database query frm main Thread
        * 2. Multithreading is not ideal for testing*/

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()


        movieDao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertMovies() {
        /*runblocking -> as we dont want concurrency so we will use it for the suspend calls.*/
        return runBlocking {
            val data = Movie(1, "ENG", "TEST", "TEST OVERVIEW", 5.0, "", "", "Test Title")
            movieDao.saveMovies(listOf(data))

            //val allMovieItems = movieDao.getAllMovies()

            val allMovieItems = movieDao.getAllMovies2().getOrAwaitValue()

            assertThat(allMovieItems).contains(data)
        }
    }

    @Test
    fun deleteMovies() {
        return runBlocking {
            val data = Movie(1, "ENG", "TEST", "TEST OVERVIEW", 5.0, "", "", "Test Title")
            movieDao.saveMovies(listOf(data))
            movieDao.deleteAllMovies()

            val allMovieItems = movieDao.getAllMovies2().getOrAwaitValue()

            assertThat(allMovieItems).doesNotContain(data)
        }
    }

    @Test
    fun getAllMoviesSize(){
        runBlocking {
            val data = Movie(1, "ENG", "TEST", "TEST OVERVIEW", 5.0, "", "", "Test Title")
            val data1 = Movie(2, "ENG", "TEST", "TEST OVERVIEW", 5.0, "", "", "Test Title")
            val data2 = Movie(3, "ENG", "TEST", "TEST OVERVIEW", 5.0, "", "", "Test Title")
            movieDao.saveMovies(listOf(data,data1,data2))

            val allMovieItems = movieDao.getAllMovies2().getOrAwaitValue()

            assertThat(allMovieItems).hasSize(3)
        }
    }
}