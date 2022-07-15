package com.lk.infinitx.workouterz.data.repository

import android.util.Log
import com.lk.infinitx.workouterz.data.datasource.*
import com.lk.infinitx.workouterz.data.entity.Excercise
import java.lang.Exception
import javax.inject.Inject

class ExcerciseRepositoryImpl @Inject constructor (

    private val cacheDataSource: CacheDataSource,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource

): ExcerciseRepository {

    override suspend fun getAll(): List<Excercise> {
        return getFromCache()
    }

    override suspend fun save(excercise: Excercise): Long {
        return localDataSource.save(excercise)
    }

    override suspend fun saveALL(list: List<Excercise>){
       localDataSource.saveList(list)
    }

    private suspend fun getFromCache():List<Excercise>{
        lateinit var list : List<Excercise>
        try {
            list = cacheDataSource.getFromCache()
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

    private suspend fun getFromDB():List<Excercise>{
        lateinit var list : List<Excercise>
        try {
            list = localDataSource.getAllFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(list.size>0){
            return list
        }else{
            list = getFromAPI()
            localDataSource.saveList(list)
        }
        return list
    }

    private suspend fun getFromAPI():List<Excercise>{
        return remoteDataSource.getAllFromAPI()
    }


}