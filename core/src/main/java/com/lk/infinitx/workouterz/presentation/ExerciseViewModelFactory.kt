package com.lk.infinitx.workouterz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase


class ExerciseViewModelFactory(
    private val getExerciseUseCase: GetExerciseUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExerciseViewModel(getExerciseUseCase) as T
    }
}
