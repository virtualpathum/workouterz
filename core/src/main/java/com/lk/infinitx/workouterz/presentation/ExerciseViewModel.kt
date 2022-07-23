package com.lk.infinitx.workouterz.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ExerciseViewModel(private val getExerciseUseCase: GetExerciseUseCase
):ViewModel() {

    fun getExerciseList() = liveData {
       // viewModelScope.launch(Dispatchers.IO) {
            val list = getExerciseUseCase.execute()
            emit(list)
       // }
    }

}