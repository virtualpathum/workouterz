package com.lk.infinitx.workouterz.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(history: History):Long

    @Query("SELECT * FROM tbl_history")
    fun getAll():Flow<List<History>>
}