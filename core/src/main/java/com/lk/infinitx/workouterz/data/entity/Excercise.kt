package com.lk.infinitx.workouterz.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_excercise")
data class Excercise(

    @PrimaryKey(autoGenerate = true)
    private var id:Int,
    private var name:String,
    private var image:Int,
    private var isCompleted:Boolean,
    private var isSelected:Boolean

){
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getImage(): Int {
        return image
    }

    fun setImage(image: Int) {
        this.image = image
    }

    fun getIsCompleted(): Boolean {
        return isCompleted
    }

    fun setIsCompleted(isCompleted: Boolean) {
        this.isCompleted = isCompleted
    }

    fun getIsSelected(): Boolean {
        return isSelected
    }

    fun setIsSelected(isSelected: Boolean) {
        this.isSelected = isSelected
    }

    companion object {
        val empty = Excercise(
            0, "", 0, false,
            false
        )
    }
}
