package com.lk.infinitx.workouterz

object Constants {
        const val LOCAL = "LOCAL"
        const val REMOTE = "REMOTE"


    fun defaultExcerciseList():ArrayList<ExcerciseModel>{
        val excerciseList = ArrayList<ExcerciseModel>()

        val jumpingJacks = ExcerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        );

        val plank = ExcerciseModel(
            2,
            "Plank",
            R.drawable.ic_plank,
            false,
            false
        );

        val wallSit = ExcerciseModel(
            3,
            "Wall Sit",
            R.drawable.ic_wall_sit,
            false,
            false
        );

        val pushUp = ExcerciseModel(
            4,
            "Push Up",
            R.drawable.ic_push_up,
            false,
            false
        );

        val pushUpRotate = ExcerciseModel(
            5,
            "Push Up and Rotate",
            R.drawable.ic_push_up_and_rotation,
            false,
            false
        );

        val abdominalCrunch = ExcerciseModel(
            6,
            "Abdominal Crunch",
            R.drawable.ic_abdominal_crunch,
            false,
            false
        );
        val lunge = ExcerciseModel(
            7,
            "Lunge",
            R.drawable.ic_lunge,
            false,
            false
        );
        val sidePlank = ExcerciseModel(
            8,
            "Side Plank",
            R.drawable.ic_side_plank,
            false,
            false
        );
        val squat = ExcerciseModel(
            9,
            "Squat",
            R.drawable.ic_squat,
            false,
            false
        );
        val stepUpChair = ExcerciseModel(
            10,
            "Step Up onto Chair",
            R.drawable.ic_step_up_onto_chair,
            false,
            false
        );
        val tricepDipOnChair = ExcerciseModel(
            11,
            "Triceps Dip On Chair",
            R.drawable.ic_triceps_dip_on_chair,
            false,
            false
        );

        val highKneesRunning = ExcerciseModel(
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
}