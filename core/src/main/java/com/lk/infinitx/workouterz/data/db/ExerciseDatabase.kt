package com.lk.infinitx.workouterz.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import com.lk.infinitx.workouterz.utils.Converters


@Database(entities = [Exercise::class,History::class], version = 2)
@TypeConverters(Converters::class)
abstract class ExerciseDatabase : RoomDatabase() {

    abstract fun exerciseDAO():ExerciseDAO

    abstract fun historyDAO():HistoryDAO

}