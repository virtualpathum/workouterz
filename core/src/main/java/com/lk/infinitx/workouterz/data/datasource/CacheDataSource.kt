package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Exercise

interface CacheDataSource {

    fun getFromCache():List<Exercise>
    fun saveToCache(exercises :List<Exercise>)

}