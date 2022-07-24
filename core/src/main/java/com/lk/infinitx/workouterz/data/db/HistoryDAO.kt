package com.lk.infinitx.workouterz.data.db

import androidx.room.*
import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(history: History):Long

    @Query("SELECT * FROM tbl_history")
    fun getAll():Flow<List<History>>

    @Query("DELETE FROM tbl_history")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(history: History)
}