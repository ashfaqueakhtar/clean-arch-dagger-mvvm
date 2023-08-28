package com.example.dagger2exmp.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dagger2exmp.domain.usecase.GetTvUseCase
import com.example.dagger2exmp.domain.usecase.UpdateTvUseCase

class TvViewModel(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvUseCase: UpdateTvUseCase
) : ViewModel() {
    fun getTvShows() = liveData {
        val tvShowList = getTvUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvUseCase.execute()
        emit(tvShowList)
    }
}