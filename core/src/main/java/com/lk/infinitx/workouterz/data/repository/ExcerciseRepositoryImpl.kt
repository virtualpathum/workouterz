package com.lk.infinitx.workouterz.data.repository

import android.util.Log
import com.lk.infinitx.workouterz.data.datasource.CacheDataSource
import com.lk.infinitx.workouterz.data.datasource.LocalDataSource
import com.lk.infinitx.workouterz.data.datasource.RemoteDataSource
import com.lk.infinitx.workouterz.data.entity.Excercise
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ExcerciseRepositoryImpl @Inject constructor (

    private val cacheDataSource: CacheDataSource,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource

): ExcerciseRepository {

    override fun getAll(): List<Excercise> {
        return getFromCache()
    }

    override suspend fun save(excercise: Excercise): Long {
        return localDataSource.save(excercise)
    }

    override suspend fun saveALL(list: List<Excercise>){
       localDataSource.saveList(list)
    }

    private fun getFromCache():List<Excercise>{
        lateinit var list : List<Excercise>
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

    private fun getFromDB():List<Excercise>{
        lateinit var list : List<Excercise>
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

    private suspend fun getFromAPI():List<Excercise>{
        return remoteDataSource.getAllFromAPI()
    }


}