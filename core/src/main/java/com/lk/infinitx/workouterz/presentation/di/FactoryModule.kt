package com.lk.infinitx.workouterz.presentation.di

import android.app.Application
import com.lk.infinitx.workouterz.interactor.GetExcerciseUseCase
import com.lk.infinitx.workouterz.presentation.ExcerciseViewModelFactory
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
    fun providesViewModelFactory(getExcerciseUseCase: GetExcerciseUseCase):ExcerciseViewModelFactory{
        return ExcerciseViewModelFactory(getExcerciseUseCase)
    }
}