package com.lk.infinitx.workouterz.data

import com.lk.infinitx.workouterz.ExcerciseModel

interface ExcerciseRepository {

    fun getExcerciseList():List<ExcerciseModel>
}