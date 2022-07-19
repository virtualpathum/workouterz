package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.data.entity.Exercise

interface RemoteDataSource {

    suspend fun getAllFromAPI():List<Exercise>
}