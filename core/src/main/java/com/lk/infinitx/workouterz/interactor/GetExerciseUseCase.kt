package com.lk.infinitx.workouterz.interactor

import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.repository.ExerciseRepository
import javax.inject.Inject

class GetExerciseUseCase @Inject constructor(private val exerciseRepository: ExerciseRepository){
   fun execute(): List<Exercise> = exerciseRepository.getAll()

}