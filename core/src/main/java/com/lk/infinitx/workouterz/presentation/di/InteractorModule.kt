package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.repository.ExcerciseRepository
import com.lk.infinitx.workouterz.interactor.GetExcerciseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InteractorModule {

    @Provides
    @Singleton
    fun provideGetUseCase(excerciseRepository: ExcerciseRepository):GetExcerciseUseCase{
        return GetExcerciseUseCase(excerciseRepository)
    }

}