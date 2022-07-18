package com.lk.infinitx.workouterz.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lk.infinitx.workouterz.data.entity.Excercise


@Database(entities = [Excercise::class], version = 1)
abstract class ExcerciseDatabase : RoomDatabase() {

    abstract fun exerciseDAO():ExcerciseDAO

}