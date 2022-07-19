package com.lk.infinitx.workouterz.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lk.infinitx.workouterz.data.entity.Exercise

@Dao
interface ExerciseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(list:List<Exercise>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(exercise: Exercise):Long

    @Query("DELETE FROM tbl_exercise")
    fun delete() : Int

    @Query("SELECT * FROM tbl_exercise")
    suspend fun getAll():List<Exercise>
}