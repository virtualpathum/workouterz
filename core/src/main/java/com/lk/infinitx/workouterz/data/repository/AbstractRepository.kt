package com.lk.infinitx.workouterz.data.repository


interface AbstractRepository<T> {

    suspend fun get(type:String):T

}