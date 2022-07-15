package com.lk.infinitx.workouterz.data

import com.lk.infinitx.workouterz.Constants
import com.lk.infinitx.workouterz.ExcerciseModel
import com.lk.infinitx.workouterz.R
import javax.inject.Inject

class ExcerciseRepositoryImpl @Inject constructor (

    private val localDataSourceImpl: LocalDataSourceImpl,
    private val remoteDataSourceImpl: RemoteDataSourceImpl

):AbstractRepository<List<Excercise>> {

    override suspend fun get(type: String): List<Excercise> {
        return when (type) {
            Constants.LOCAL -> localDataSourceImpl.getAll()
            Constants.REMOTE -> remoteDataSourceImpl.getAll()
            else -> {
                listOf<Excercise>()}
        }

    }


}