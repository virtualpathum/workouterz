package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Excercise

interface CacheDataSource {

    fun getFromCache():List<Excercise>
    fun saveToCache(exercises :List<Excercise>)

}