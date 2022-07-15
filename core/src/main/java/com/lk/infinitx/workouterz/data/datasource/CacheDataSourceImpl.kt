package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Excercise

class CacheDataSourceImpl:CacheDataSource {

    private var list = ArrayList<Excercise>()

    override suspend fun getFromCache(): List<Excercise> {
        return list
    }

    override suspend fun saveToCache(excercises: List<Excercise>) {
        list.clear()
        list.addAll(excercises)
    }
}