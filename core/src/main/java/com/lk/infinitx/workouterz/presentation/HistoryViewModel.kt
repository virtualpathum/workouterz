package com.lk.infinitx.workouterz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.lk.infinitx.workouterz.data.entity.History
import com.lk.infinitx.workouterz.interactor.GetHistoryUseCase
import com.lk.infinitx.workouterz.interactor.SaveHistoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(

    private val getHistoryUseCase: GetHistoryUseCase,
    private val saveHistoryUseCase: SaveHistoryUseCase):ViewModel() {


         val list = getHistoryUseCase.execute()

       /* fun getHistory() = liveData {
            viewModelScope.launch(Dispatchers.IO) {

                emit(list)
            }

        }*/

        fun saveHistory(history: History) = liveData<Long> {
            viewModelScope.launch(Dispatchers.IO) {
                val id = saveHistoryUseCase.execute(history)
                emit(id)
            }
        }
}