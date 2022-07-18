package com.lk.infinitx.workouterz.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase


class ExerciseViewModel(private val getExerciseUseCase: GetExerciseUseCase
):ViewModel() {

    fun getExerciseList() = liveData {
        Log.i("MyTag", "Inside Live Data VM")
        val list = getExerciseUseCase.execute()
        Log.i("MyTag","list size VM : "+ list.size)
        emit(list)
    }

}