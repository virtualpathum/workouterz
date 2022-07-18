package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.repository.ExcerciseRepository
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providesUseCase(exerciseRepository: ExcerciseRepository):GetExerciseUseCase{
        return GetExerciseUseCase(exerciseRepository)
    }
}