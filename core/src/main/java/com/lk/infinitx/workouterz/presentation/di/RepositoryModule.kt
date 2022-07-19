package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.datasource.CacheDataSource
import com.lk.infinitx.workouterz.data.datasource.LocalDataSource
import com.lk.infinitx.workouterz.data.datasource.RemoteDataSource
import com.lk.infinitx.workouterz.data.repository.ExerciseRepository
import com.lk.infinitx.workouterz.data.repository.ExerciseRepositoryImpl
import com.lk.infinitx.workouterz.data.repository.HistoryRepository
import com.lk.infinitx.workouterz.data.repository.HistoryRepositoryImpl
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
    fun providesExerciseRepository(cacheDataSource: CacheDataSource,localDataSource: LocalDataSource,remoteDataSource: RemoteDataSource): ExerciseRepository {
        return ExerciseRepositoryImpl(cacheDataSource,localDataSource,remoteDataSource)
    }

    @Provides
    @Singleton
    fun providesHistoryRepository(localDataSource: LocalDataSource):HistoryRepository{
        return HistoryRepositoryImpl(localDataSource)
    }
}