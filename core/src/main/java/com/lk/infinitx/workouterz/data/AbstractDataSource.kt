package com.lk.infinitx.workouterz.data

interface AbstractDataSource<T> {
    suspend fun getAll():T
    suspend fun save(instance:T):T
}