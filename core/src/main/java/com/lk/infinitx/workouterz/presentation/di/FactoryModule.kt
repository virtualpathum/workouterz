/*
package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase
import com.lk.infinitx.workouterz.interactor.GetHistoryUseCase
import com.lk.infinitx.workouterz.interactor.SaveHistoryUseCase
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
    fun providesVMFExercise(getExerciseUseCase: GetExerciseUseCase):ExerciseViewModelFactory{
        return ExerciseViewModelFactory(getExerciseUseCase)
    }

    @Provides
    @Singleton
    fun providesVMFHistory(getHistoryUseCase: GetHistoryUseCase,
                           saveHistoryUseCase: SaveHistoryUseCase): HistoryViewModelFactory {
        return HistoryViewModelFactory(getHistoryUseCase,saveHistoryUseCase)
    }
}*/
