package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Excercise

interface RemoteDataSource {

    suspend fun getAllFromAPI():List<Excercise>
}