package com.lk.infinitx.workouterz.data.repository

import com.lk.infinitx.workouterz.data.entity.Exercise

interface ExerciseRepository {
    fun getAll(): List<Exercise>
    suspend fun save(excercise: Exercise): Long
    suspend fun saveALL(list: List<Exercise>)
    suspend fun update():List<Exercise>
}