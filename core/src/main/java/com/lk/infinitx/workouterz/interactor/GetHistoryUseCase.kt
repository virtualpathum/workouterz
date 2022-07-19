package com.lk.infinitx.workouterz.interactor

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import com.lk.infinitx.workouterz.data.repository.ExerciseRepository
import com.lk.infinitx.workouterz.data.repository.HistoryRepository
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val historyRepository: HistoryRepository){
   suspend fun execute(): List<History> = historyRepository.getAll()

}