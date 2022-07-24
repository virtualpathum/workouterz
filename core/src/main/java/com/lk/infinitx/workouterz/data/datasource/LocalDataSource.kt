package com.lk.infinitx.workouterz.data.datasource

import androidx.compose.runtime.State
import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllFromDB(): List<Exercise>

    suspend fun save(exercise: Exercise):Long

    suspend fun saveList(list:List<Exercise>)

    suspend fun save(history: History):Long

    fun getAllHistoryFromDB(): Flow<List<History>>

    suspend fun deleteAll()

    suspend fun delete(history: History)

}