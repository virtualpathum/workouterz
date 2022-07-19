package com.lk.infinitx.workouterz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lk.infinitx.workouterz.interactor.GetExerciseUseCase
import com.lk.infinitx.workouterz.interactor.GetHistoryUseCase
import com.lk.infinitx.workouterz.interactor.SaveHistoryUseCase


class HistoryViewModelFactory(
    private val getHistoryUseCase: GetHistoryUseCase,
private val saveHistoryUseCase: SaveHistoryUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HistoryViewModel(getHistoryUseCase,saveHistoryUseCase) as T
    }
}
