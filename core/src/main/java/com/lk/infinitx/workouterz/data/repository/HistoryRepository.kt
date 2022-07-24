package com.lk.infinitx.workouterz.data.repository

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    fun getAll(): Flow<List<History>>
    suspend fun save(history: History): Long
    suspend fun deleteAll()
    suspend fun delete(history: History)
}