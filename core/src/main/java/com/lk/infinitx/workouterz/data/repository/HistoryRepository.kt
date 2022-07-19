package com.lk.infinitx.workouterz.data.repository

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History

interface HistoryRepository {

    suspend fun getAll(): List<History>
    suspend fun save(history: History): Long
}