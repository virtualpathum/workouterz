package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.datasource.*
import com.lk.infinitx.workouterz.data.db.ExcerciseDAO
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
    fun provideLocalDataSource(exerciseDAO: ExcerciseDAO):LocalDataSource{
        return LocalDataSourceImpl(exerciseDAO)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource():RemoteDataSource{
        return RemoteDataSourceImpl()
    }

}