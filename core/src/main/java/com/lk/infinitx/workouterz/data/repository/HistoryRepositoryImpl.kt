package com.lk.infinitx.workouterz.data.repository

import com.lk.infinitx.workouterz.data.datasource.LocalDataSource
import com.lk.infinitx.workouterz.data.entity.History
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl(private val localDataSource: LocalDataSource) : HistoryRepository {

    override fun getAll(): Flow<List<History>> {
        return localDataSource.getAllHistoryFromDB()
    }

    override suspend fun save(history: History): Long {
       return localDataSource.save(history)
    }
}