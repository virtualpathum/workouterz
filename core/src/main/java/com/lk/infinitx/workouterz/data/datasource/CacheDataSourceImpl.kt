package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Excercise

class CacheDataSourceImpl:CacheDataSource {

    private var list = ArrayList<Excercise>()

    override fun getFromCache(): List<Excercise> {
       return list
    }

    override fun saveToCache(excercises: List<Excercise>) {
        list.clear()
        list.addAll(excercises)
    }
}