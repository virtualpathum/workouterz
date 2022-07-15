package com.lk.infinitx.workouterz.interactor

import com.lk.infinitx.workouterz.utils.Constants
import com.lk.infinitx.workouterz.data.entity.Excercise
import com.lk.infinitx.workouterz.data.repository.AbstractRepository
import com.lk.infinitx.workouterz.data.repository.ExcerciseRepository
import javax.inject.Inject

class GetExcerciseUseCase @Inject constructor(private val excerciseRepository: ExcerciseRepository){
    suspend fun execute(): List<Excercise> = excerciseRepository.getAll()

}