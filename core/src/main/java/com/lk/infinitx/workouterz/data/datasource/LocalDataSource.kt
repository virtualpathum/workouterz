package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Excercise

interface LocalDataSource {

    suspend fun getAllFromDB(): List<Excercise>

    suspend fun save(excercise: Excercise):Long

    suspend fun saveList(list:List<Excercise>)

}