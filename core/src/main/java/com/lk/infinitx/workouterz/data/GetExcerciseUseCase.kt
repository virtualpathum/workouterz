package com.lk.infinitx.workouterz.data

import com.lk.infinitx.workouterz.Constants
import com.lk.infinitx.workouterz.ExcerciseModel
import javax.inject.Inject

class GetExcerciseUseCase @Inject constructor(private val excerciseRepository: AbstractRepository<List<Excercise>>):

    BaseUseCase<List<Excercise>, BaseUseCase.None>() {
    override suspend fun execute(params: BaseUseCase.None): List<Excercise> = excerciseRepository.get(Constants.LOCAL)

}