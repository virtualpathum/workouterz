package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.datasource.*
import com.lk.infinitx.workouterz.data.db.ExerciseDAO
import com.lk.infinitx.workouterz.data.db.HistoryDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideCacheDataSource():CacheDataSource{
        return CacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(exerciseDAO: ExerciseDAO,historyDAO: HistoryDAO):LocalDataSource{
        return LocalDataSourceImpl(exerciseDAO,historyDAO)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource():RemoteDataSource{
        return RemoteDataSourceImpl()
    }

}