package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.R
import com.lk.infinitx.workouterz.data.db.ExcerciseDAO
import com.lk.infinitx.workouterz.data.entity.Excercise

class LocalDataSourceImpl(private val excerciseDAO: ExcerciseDAO): LocalDataSource {

    override fun getAllFromDB(): List<Excercise> {
            val list = ArrayList<Excercise>()

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
            list.add(jumpingJacks)
            list.add(plank)
            list.add(wallSit)
            list.add(pushUp)
            list.add(pushUpRotate)
            list.add(abdominalCrunch)
            list.add(lunge)
            list.add(sidePlank)
            list.add(tricepDipOnChair)
            list.add(stepUpChair)
            list.add(squat)
            list.add(highKneesRunning)

            return list;


        }

    override suspend fun save(excercise: Excercise): Long {
        return excerciseDAO.save(excercise)
    }

    override suspend fun saveList(list: List<Excercise>) {
        excerciseDAO.save(list)
    }
}