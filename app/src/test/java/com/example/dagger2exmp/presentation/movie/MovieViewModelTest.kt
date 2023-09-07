package com.example.dagger2exmp.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dagger2exmp.domain.usecase.GetMoviesUseCase
import com.example.dagger2exmp.domain.usecase.UpdateMovieUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

class MovieViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel


    @Mock
    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Mock
    private lateinit var updateMovieUseCase: UpdateMovieUseCase

    @Before
    fun setUp() {
        getMoviesUseCase = GetMoviesUseCase(FakeMovieRepository())
        updateMovieUseCase = UpdateMovieUseCase(FakeMovieRepository())

        viewModel = MovieViewModel(getMoviesUseCase, updateMovieUseCase)
    }

    @Test
    fun testNull() {
        assertNotNull(viewModel.getMovies())
    }

    @Test
    fun getMovies_inputNothing_returnList() {
        runBlocking {
            val list = getMoviesUseCase.execute()
            Truth.assertThat(list).hasSize(0)
        }
    }


}