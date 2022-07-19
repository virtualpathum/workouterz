package com.lk.infinitx.workouterz.presentation.di

import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverters
import com.lk.infinitx.workouterz.data.db.ExerciseDAO
import com.lk.infinitx.workouterz.data.db.ExerciseDatabase
import com.lk.infinitx.workouterz.data.db.HistoryDAO
import com.lk.infinitx.workouterz.utils.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):ExerciseDatabase{
        return Room.databaseBuilder(context,ExerciseDatabase::class.java,"workouterz")
            .addTypeConverter(Converters()).build()
    }

    @Singleton
    @Provides
    fun provideExerciseDAO(exerciseDatabase: ExerciseDatabase): ExerciseDAO {
        return exerciseDatabase.exerciseDAO()
    }

    @Singleton
    @Provides
    fun provideHistoryDAO(exerciseDatabase: ExerciseDatabase):HistoryDAO{
        return exerciseDatabase.historyDAO()
    }
}
