package com.lk.infinitx.workouterz.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ExerciseViewModel @Inject constructor(private val getExerciseUseCase: GetExerciseUseCase
):ViewModel() {

    fun getExerciseList() = liveData {
       // viewModelScope.launch(Dispatchers.IO) {
            val list = getExerciseUseCase.execute()
            emit(list)
       // }
    }

}