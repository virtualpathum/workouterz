package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase
import com.lk.infinitx.workouterz.presentation.ExerciseViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun providesViewModelFactory(getExerciseUseCase: GetExerciseUseCase):ExerciseViewModelFactory{
        return ExerciseViewModelFactory(getExerciseUseCase)
    }
}