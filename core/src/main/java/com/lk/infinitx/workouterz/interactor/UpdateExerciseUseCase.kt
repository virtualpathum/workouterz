package com.lk.infinitx.workouterz.interactor

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.repository.ExerciseRepository
import javax.inject.Inject

class UpdateExerciseUseCase @Inject constructor(private val exerciseRepository: ExerciseRepository){
   suspend fun execute(): List<Exercise> = exerciseRepository.update()

}