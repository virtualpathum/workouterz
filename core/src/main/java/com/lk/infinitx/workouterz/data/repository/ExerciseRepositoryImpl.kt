package com.lk.infinitx.workouterz.data.repository

import android.util.Log
import com.lk.infinitx.workouterz.data.datasource.CacheDataSource
import com.lk.infinitx.workouterz.data.datasource.LocalDataSource
import com.lk.infinitx.workouterz.data.datasource.RemoteDataSource
import com.lk.infinitx.workouterz.data.entity.Exercise
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor (

    private val cacheDataSource: CacheDataSource,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource

): ExerciseRepository {

    override fun getAll(): List<Exercise> {
        return getFromCache()
    }

    override suspend fun save(excercise: Exercise): Long {
        return localDataSource.save(excercise)
    }

    override suspend fun saveALL(list: List<Exercise>){
       localDataSource.saveList(list)
    }

    override suspend fun update(): List<Exercise> {
        TODO("Not yet implemented")
    }

    private fun getFromCache():List<Exercise>{
        lateinit var list : List<Exercise>
        try {
            list = cacheDataSource.getFromCache()
            Log.i("MyTag","list size cache: "+ list.size)
        }catch (exception: Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(list.size>0){
            return list
        }else{
            list = getFromDB()
            cacheDataSource.saveToCache(list)
        }
        return list
    }

    private fun getFromDB():List<Exercise>{
        lateinit var list : List<Exercise>
        try {
            list = localDataSource.getAllFromDB()
            Log.i("MyTag","list size DB: "+ list.size)
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(list.size>0){
            return list
        }else{
            list = runBlocking { getFromAPI()}
            runBlocking {
                localDataSource.saveList(list)
            }
        }
        return list
    }

    private suspend fun getFromAPI():List<Exercise>{
        return remoteDataSource.getAllFromAPI()
    }


}