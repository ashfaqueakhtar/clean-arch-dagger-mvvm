package com.example.dagger2exmp.domain.usecase

import com.example.dagger2exmp.data.model.tv.Tv
import com.example.dagger2exmp.domain.repository.TvRepository

class UpdateTvUseCase(private val tvRepository: TvRepository) {
    suspend fun execute():List<Tv>? = tvRepository.updateTvShows()
}