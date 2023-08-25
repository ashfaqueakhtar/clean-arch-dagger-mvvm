package com.example.dagger2exmp.data.repository.tvShow

import android.util.Log
import com.example.dagger2exmp.data.model.tv.Tv
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvCacheDataSource
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvLocalDataSource
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvRemoteDataSource
import com.example.dagger2exmp.domain.repository.TvRepository
import java.lang.Exception

class TvRepositoryImpl(
    private val tvRemoteDataSource: TvRemoteDataSource,
    private val tvLocalDataSource: TvLocalDataSource,
    private val tvCacheDataSource: TvCacheDataSource
) : TvRepository {
    override suspend fun getTvShows(): List<Tv>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<Tv>? {
        val newListOfDta = getTvShowFromApi()
        tvLocalDataSource.clearAll()
        tvLocalDataSource.saveTvShowToDB(tv = newListOfDta)
        tvCacheDataSource.saveTvShowToCache(newListOfDta)
        return newListOfDta
    }


    suspend fun getTvShowFromApi(): List<Tv> {
        lateinit var tvShowList: List<Tv>

        try {
            val response = tvRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                body.tvs?.let { tvShowList = it }
            }
        } catch (e: Exception) {
            Log.d(TvRepositoryImpl::class.java.simpleName, "" + e.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<Tv> {
        lateinit var tvShowList: List<Tv>

        try {
            tvShowList = tvLocalDataSource.getTvShowFromDB()
        } catch (e: Exception) {
            Log.d(TvRepositoryImpl::class.java.simpleName, "" + e.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromApi()
            tvLocalDataSource.saveTvShowToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<Tv> {
        lateinit var tvShowList: List<Tv>

        try {
            tvShowList = tvCacheDataSource.getTvShowFromCache()
        } catch (e: Exception) {
            Log.d(TvRepositoryImpl::class.java.simpleName, "" + e.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromDB()
            tvCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }
}