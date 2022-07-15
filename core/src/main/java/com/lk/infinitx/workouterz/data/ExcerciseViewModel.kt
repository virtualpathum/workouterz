package com.lk.infinitx.workouterz.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lk.infinitx.workouterz.ExcerciseModel


class ExcerciseViewModel(private val getExcerciseUseCase: GetExcerciseUseCase):ViewModel() {

    fun getExcerciseList()= liveData<List<Excercise>> {
        val excerciseList = getExcerciseUseCase.execute(BaseUseCase.None())
        emit(excerciseList)
    }

}