package com.lk.infinitx.workouterz.interactor

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import com.lk.infinitx.workouterz.data.repository.ExerciseRepository
import com.lk.infinitx.workouterz.data.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val historyRepository: HistoryRepository){
   fun execute(): Flow<List<History>> = historyRepository.getAll()

}