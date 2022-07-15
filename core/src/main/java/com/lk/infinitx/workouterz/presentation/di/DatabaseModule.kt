package com.lk.infinitx.workouterz.presentation.di

import android.content.Context
import androidx.room.Room
import com.lk.infinitx.workouterz.data.db.ExcerciseDAO
import com.lk.infinitx.workouterz.data.db.ExcerciseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context):ExcerciseDatabase{
        return Room.databaseBuilder(context,ExcerciseDatabase::class.java,"workouterz").build()
    }

    @Singleton
    @Provides
    fun provideDAO(excerciseDatabase: ExcerciseDatabase):ExcerciseDAO{
        return excerciseDatabase.excerciseDAO()
    }
}
