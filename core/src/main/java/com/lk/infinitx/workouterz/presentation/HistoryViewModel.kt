package com.lk.infinitx.workouterz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lk.infinitx.workouterz.data.entity.History
import com.lk.infinitx.workouterz.interactor.GetHistoryUseCase
import com.lk.infinitx.workouterz.interactor.SaveHistoryUseCase

class HistoryViewModel(

    private val getHistoryUseCase: GetHistoryUseCase,
    private val saveHistoryUseCase: SaveHistoryUseCase):ViewModel() {

        fun getHistory() = liveData<List<History>> {
            val list = getHistoryUseCase.execute()
            emit(list)
        }

        fun saveHistory(history: History) = liveData<Long> {
            val id = saveHistoryUseCase.execute(history)
            emit(id)
        }
}