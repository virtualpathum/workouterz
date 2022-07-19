package com.lk.infinitx.workouterz.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase


class ExerciseViewModel(private val getExerciseUseCase: GetExerciseUseCase
):ViewModel() {

    fun getExerciseList() = liveData {
        val list = getExerciseUseCase.execute()
        emit(list)
    }

}