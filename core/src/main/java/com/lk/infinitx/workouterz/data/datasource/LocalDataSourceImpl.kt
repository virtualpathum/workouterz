package com.lk.infinitx.workouterz.data.datasource

import com.lk.infinitx.workouterz.R
import com.lk.infinitx.workouterz.data.db.ExerciseDAO
import com.lk.infinitx.workouterz.data.db.HistoryDAO
import com.lk.infinitx.workouterz.data.entity.Exercise
import com.lk.infinitx.workouterz.data.entity.History
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val exerciseDAO: ExerciseDAO, private val historyDAO: HistoryDAO): LocalDataSource {

    override fun getAllFromDB(): List<Exercise> {
            val list = ArrayList<Exercise>()

            val jumpingJacks = Exercise(
                1,
                "Jumping Jacks",
                R.drawable.ic_jumping_jacks,
                false,
                false
            );

            val plank = Exercise(
                2,
                "Plank",
                R.drawable.ic_plank,
                false,
                false
            );

            val wallSit = Exercise(
                3,
                "Wall Sit",
                R.drawable.ic_wall_sit,
                false,
                false
            );

            val pushUp = Exercise(
                4,
                "Push Up",
                R.drawable.ic_push_up,
                false,
                false
            );

            val pushUpRotate = Exercise(
                5,
                "Push Up and Rotate",
                R.drawable.ic_push_up_and_rotation,
                false,
                false
            );

            val abdominalCrunch = Exercise(
                6,
                "Abdominal Crunch",
                R.drawable.ic_abdominal_crunch,
                false,
                false
            );
            val lunge = Exercise(
                7,
                "Lunge",
                R.drawable.ic_lunge,
                false,
                false
            );
            val sidePlank = Exercise(
                8,
                "Side Plank",
                R.drawable.ic_side_plank,
                false,
                false
            );
            val squat = Exercise(
                9,
                "Squat",
                R.drawable.ic_squat,
                false,
                false
            );
            val stepUpChair = Exercise(
                10,
                "Step Up onto Chair",
                R.drawable.ic_step_up_onto_chair,
                false,
                false
            );
            val tricepDipOnChair = Exercise(
                11,
                "Triceps Dip On Chair",
                R.drawable.ic_triceps_dip_on_chair,
                false,
                false
            );

            val highKneesRunning = Exercise(
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

    override suspend fun save(excercise: Exercise): Long {
        return exerciseDAO.save(excercise)
    }

    override suspend fun saveList(list: List<Exercise>) {
        exerciseDAO.save(list)
    }

    override suspend fun save(history: History): Long {
        return historyDAO.save(history)
    }

    override fun getAllHistoryFromDB(): Flow<List<History>> {
        return historyDAO.getAll()
    }

    override suspend fun deleteAll(){
        historyDAO.deleteAll()
    }

    override suspend fun delete(history: History) {
        historyDAO.delete(history)
    }
}