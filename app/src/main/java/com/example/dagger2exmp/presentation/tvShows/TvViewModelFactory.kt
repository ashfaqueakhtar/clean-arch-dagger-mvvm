package com.example.dagger2exmp.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2exmp.domain.usecase.GetTvUseCase

class TvViewModelFactory(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvUseCase: GetTvUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvUseCase, updateTvUseCase) as T
    }
}