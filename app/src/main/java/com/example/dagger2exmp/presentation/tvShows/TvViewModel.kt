package com.example.dagger2exmp.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dagger2exmp.domain.usecase.GetTvUseCase

class TvViewModel(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvUseCase: GetTvUseCase
) : ViewModel() {
    fun getTvShows() = liveData {
        val tvShowList = getTvUseCase.execute()
        emit(tvShowList)
    }

    fun updateMovie() = liveData {
        val tvShowList = updateTvUseCase.execute()
        emit(tvShowList)
    }
}