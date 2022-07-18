package com.lk.infinitx.workouterz.data.repository

import com.lk.infinitx.workouterz.data.entity.Excercise

interface ExcerciseRepository {
    fun getAll(): List<Excercise>
    suspend fun save(excercise: Excercise): Long
    suspend fun saveALL(list: List<Excercise>)
}