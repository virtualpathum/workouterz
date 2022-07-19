package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.repository.ExerciseRepository
import com.lk.infinitx.workouterz.data.repository.HistoryRepository
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase
import com.lk.infinitx.workouterz.interactor.GetHistoryUseCase
import com.lk.infinitx.workouterz.interactor.SaveHistoryUseCase
import com.lk.infinitx.workouterz.interactor.UpdateExerciseUseCase
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
    fun providesGetExerciseUseCase(exerciseRepository: ExerciseRepository):GetExerciseUseCase{
        return GetExerciseUseCase(exerciseRepository)
    }


    @Provides
    @Singleton
    fun providesUpdateExerciseUseCase(exerciseRepository: ExerciseRepository): UpdateExerciseUseCase {
        return UpdateExerciseUseCase(exerciseRepository)
    }

    @Provides
    @Singleton
    fun providesGetHistoryUseCase(historyRepository: HistoryRepository):GetHistoryUseCase{
        return GetHistoryUseCase(historyRepository)
    }

    @Provides
    @Singleton
    fun providesSaveHistoryUseCase(historyRepository: HistoryRepository): SaveHistoryUseCase {
        return SaveHistoryUseCase(historyRepository)
    }
}