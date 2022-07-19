package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History

interface LocalDataSource {

    fun getAllFromDB(): List<Exercise>

    suspend fun save(exercise: Exercise):Long

    suspend fun saveList(list:List<Exercise>)

    suspend fun save(history: History):Long

    suspend fun getAllHistoryFromDB(): List<History>

}