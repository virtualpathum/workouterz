package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Excercise

interface CacheDataSource {

    suspend fun getFromCache():List<Excercise>
    suspend fun saveToCache(excercises :List<Excercise>)

}