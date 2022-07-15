package com.lk.infinitx.workouterz.data

import com.lk.infinitx.workouterz.ExcerciseModel
import com.lk.infinitx.workouterz.R

class LocalDataSourceImpl:AbstractDataSource<List<Excercise>> {

    override suspend fun getAll(): List<Excercise> {
            val excerciseList = ArrayList<Excercise>()

            val jumpingJacks = Excercise(
                1,
                "Jumping Jacks",
                R.drawable.ic_jumping_jacks,
                false,
                false
            );

            val plank = Excercise(
                2,
                "Plank",
                R.drawable.ic_plank,
                false,
                false
            );

            val wallSit = Excercise(
                3,
                "Wall Sit",
                R.drawable.ic_wall_sit,
                false,
                false
            );

            val pushUp = Excercise(
                4,
                "Push Up",
                R.drawable.ic_push_up,
                false,
                false
            );

            val pushUpRotate = Excercise(
                5,
                "Push Up and Rotate",
                R.drawable.ic_push_up_and_rotation,
                false,
                false
            );

            val abdominalCrunch = Excercise(
                6,
                "Abdominal Crunch",
                R.drawable.ic_abdominal_crunch,
                false,
                false
            );
            val lunge = Excercise(
                7,
                "Lunge",
                R.drawable.ic_lunge,
                false,
                false
            );
            val sidePlank = Excercise(
                8,
                "Side Plank",
                R.drawable.ic_side_plank,
                false,
                false
            );
            val squat = Excercise(
                9,
                "Squat",
                R.drawable.ic_squat,
                false,
                false
            );
            val stepUpChair = Excercise(
                10,
                "Step Up onto Chair",
                R.drawable.ic_step_up_onto_chair,
                false,
                false
            );
            val tricepDipOnChair = Excercise(
                11,
                "Triceps Dip On Chair",
                R.drawable.ic_triceps_dip_on_chair,
                false,
                false
            );

            val highKneesRunning = Excercise(
                12,
                "High Knees Running",
                R.drawable.ic_high_knees_running_in_place,
                false,
                false
            );
            excerciseList.add(jumpingJacks)
            excerciseList.add(plank)
            excerciseList.add(wallSit)
            excerciseList.add(pushUp)
            excerciseList.add(pushUpRotate)
            excerciseList.add(abdominalCrunch)
            excerciseList.add(lunge)
            excerciseList.add(sidePlank)
            excerciseList.add(tricepDipOnChair)
            excerciseList.add(stepUpChair)
            excerciseList.add(squat)
            excerciseList.add(highKneesRunning)

            return excerciseList;


        }

    override suspend fun save(instance: List<Excercise>): List<Excercise> {
        TODO("Not yet implemented")
    }
}