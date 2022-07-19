package com.lk.infinitx.workouterz.presentation.di

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.presentation.adapter.ExcerciseStatusAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun providesAdapter(list:ArrayList<Exercise>):ExcerciseStatusAdapter{
        return ExcerciseStatusAdapter(list)
    }
}