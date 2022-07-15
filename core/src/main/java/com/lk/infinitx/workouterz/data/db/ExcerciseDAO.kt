package com.lk.infinitx.workouterz.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lk.infinitx.workouterz.data.Excercise

@Dao
interface ExcerciseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveExcercise(movies:List<Excercise>)

    @Query("DELETE FROM tbl_excercise")
    fun deleteExcercise() : Int

    @Query("SELECT * FROM tbl_excercise")
    suspend fun getExcercises():List<Excercise>
}