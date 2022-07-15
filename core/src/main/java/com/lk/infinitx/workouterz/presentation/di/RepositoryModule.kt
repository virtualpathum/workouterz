package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.datasource.CacheDataSource
import com.lk.infinitx.workouterz.data.datasource.LocalDataSource
import com.lk.infinitx.workouterz.data.datasource.RemoteDataSource
import com.lk.infinitx.workouterz.data.repository.ExcerciseRepository
import com.lk.infinitx.workouterz.data.repository.ExcerciseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(cacheDataSource: CacheDataSource,localDataSource: LocalDataSource,remoteDataSource: RemoteDataSource): ExcerciseRepository {
        return ExcerciseRepositoryImpl(cacheDataSource,localDataSource,remoteDataSource)
    }
}