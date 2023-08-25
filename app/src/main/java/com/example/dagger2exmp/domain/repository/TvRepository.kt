package com.example.dagger2exmp.domain.repository
import com.example.dagger2exmp.data.model.tv.Tv

interface TvRepository {
    suspend fun getTvShows(): List<Tv>?

    suspend fun updateTvShows():List<Tv>?
}