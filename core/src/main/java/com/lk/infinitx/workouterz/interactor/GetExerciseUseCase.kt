package com.lk.infinitx.workouterz.interactor

import com.lk.infinitx.workouterz.data.entity.Excercise
import com.lk.infinitx.workouterz.data.repository.ExcerciseRepository
import javax.inject.Inject

class GetExerciseUseCase @Inject constructor(private val exerciseRepository: ExcerciseRepository){
   fun execute(): List<Excercise> = exerciseRepository.getAll()

}