package com.example.dagger2exmp.data.repository.tvShow.dataSourceImpl

import com.example.dagger2exmp.data.db.TvDao
import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.data.model.tv.Tv
import com.example.dagger2exmp.data.repository.tvShow.dataSource.TvLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TvLocalDataSourceImpl(private val tvDao: TvDao) : TvLocalDataSource {
    override suspend fun getTvShowFromDB(): List<Tv> {
        var data = ArrayList<Tv>()
        val deferred = CoroutineScope(Dispatchers.IO).async {
            data = ArrayList(tvDao.getAllTv())
        }
        deferred.await()
        return data
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