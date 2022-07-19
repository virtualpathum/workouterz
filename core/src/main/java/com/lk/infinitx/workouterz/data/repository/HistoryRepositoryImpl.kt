package com.lk.infinitx.workouterz.data.repository

import com.lk.infinitx.workouterz.data.datasource.LocalDataSource
import com.lk.infinitx.workouterz.data.entity.History

class HistoryRepositoryImpl(private val localDataSource: LocalDataSource) : HistoryRepository {

    override suspend fun getAll(): List<History> {
        return localDataSource.getAllHistoryFromDB()
    }

    override suspend fun save(history: History): Long {
       return localDataSource.save(history)
    }
}