package com.lk.infinitx.workouterz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lk.infinitx.workouterz.interactor.GetExcerciseUseCase


class ExcerciseViewModelFactory(private val getExcerciseUseCase: GetExcerciseUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExcerciseViewModel(getExcerciseUseCase) as T
    }
}
