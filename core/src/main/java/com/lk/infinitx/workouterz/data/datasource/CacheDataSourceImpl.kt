package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Exercise

class CacheDataSourceImpl:CacheDataSource {

    private var list = ArrayList<Exercise>()

    override fun getFromCache(): List<Exercise> {
       return list
    }

    override fun saveToCache(excercises: List<Exercise>) {
        list.clear()
        list.addAll(excercises)
    }
}