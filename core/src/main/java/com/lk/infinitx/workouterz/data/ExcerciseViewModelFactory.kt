package com.lk.infinitx.workouterz.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ExcerciseViewModelFactory(private val getExcerciseUseCase: GetExcerciseUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExcerciseViewModel(getExcerciseUseCase) as T
    }
}
