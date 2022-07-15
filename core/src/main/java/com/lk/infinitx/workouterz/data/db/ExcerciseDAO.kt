package com.lk.infinitx.workouterz.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lk.infinitx.workouterz.data.entity.Excercise

@Dao
interface ExcerciseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(list:List<Excercise>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(excercise: Excercise):Long

    @Query("DELETE FROM tbl_excercise")
    fun delete() : Int

    @Query("SELECT * FROM tbl_excercise")
    suspend fun getAll():List<Excercise>
}