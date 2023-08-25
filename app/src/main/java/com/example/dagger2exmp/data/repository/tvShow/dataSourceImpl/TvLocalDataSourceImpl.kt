package com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl

import com.example.dagger2exmp.data.db.TvDao
import com.example.dagger2exmp.data.model.tv.Tv
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvLocalDataSourceImpl(private val tvDao: TvDao) : TvLocalDataSource {
    override suspend fun getTvShowFromDB(): List<Tv> {
        return tvDao.getAllTv()
    }

    override suspend fun saveTvShowToDB(tv: List<Tv>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTv(tv)
        }
    }

    override suspend fun clearAll() {
        tvDao.deleteAllTv()
    }
}