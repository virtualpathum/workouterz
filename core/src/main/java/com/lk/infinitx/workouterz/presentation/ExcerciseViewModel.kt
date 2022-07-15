package com.lk.infinitx.workouterz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lk.infinitx.workouterz.data.entity.Excercise
import com.lk.infinitx.workouterz.interactor.BaseUseCase
import com.lk.infinitx.workouterz.interactor.GetExcerciseUseCase


class ExcerciseViewModel(private val getExcerciseUseCase: GetExcerciseUseCase):ViewModel() {

    fun getExcerciseList()= liveData<List<Excercise>> {
        val excerciseList = getExcerciseUseCase.execute()
        emit(excerciseList)
    }

}