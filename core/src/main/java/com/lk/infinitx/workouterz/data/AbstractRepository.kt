package com.lk.infinitx.workouterz.data


interface AbstractRepository<T> {

    suspend fun get(type:String):T

}