package com.lk.infinitx.workouterz.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lk.infinitx.workouterz.utils.Converters
import java.util.*

@Entity(tableName = "tbl_history")
data class History(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "exercise_name")
    var exerciseName: String,

    @ColumnInfo(name = "date")
    @TypeConverters(Converters::class)
    var date:Date,
) {

}