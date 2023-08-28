package com.example.dagger2exmp.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2exmp.domain.usecase.GetTvUseCase
import com.example.dagger2exmp.domain.usecase.UpdateTvUseCase

class TvViewModelFactory(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvUseCase: UpdateTvUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvUseCase, updateTvUseCase) as T
    }
}