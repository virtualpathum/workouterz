package com.lk.infinitx.workouterz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.lk.infinitx.workouterz.data.entity.History
import com.lk.infinitx.workouterz.interactor.GetHistoryUseCase
import com.lk.infinitx.workouterz.interactor.SaveHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(

    getHistoryUseCase: GetHistoryUseCase,
    private val saveHistoryUseCase: SaveHistoryUseCase):ViewModel() {


         val list = getHistoryUseCase.execute()

       /* fun getHistory() = liveData {
            viewModelScope.launch(Dispatchers.IO) {

                emit(list)
            }

        }*/

        fun save(history: History) = liveData<Long> {
            viewModelScope.launch(Dispatchers.IO) {
                val id = saveHistoryUseCase.execute(history)
                emit(id)
            }
        }

        fun deleteAll() =
            viewModelScope.launch(Dispatchers.IO) {
                saveHistoryUseCase.deleteAll()
            }


        fun delete(history: History) =
            viewModelScope.launch(Dispatchers.IO) {
                saveHistoryUseCase.delete(history)
            }

}