package com.example.unfitnotes1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface NewWorkoutSetDao {
    @Insert
    void insert(NewWorkoutSet set);

    @Query("SELECT * FROM new_workout_sets")
    List<NewWorkoutSet> getAllWorkoutSets();

    @Query("SELECT * FROM new_workout_sets WHERE date = :date")
    List<NewWorkoutSet> getWorkoutSetsByDate(String date);

    @Query("SELECT * FROM new_workout_sets WHERE exercise_name = :exerciseName")
    List<NewWorkoutSet> getWorkoutSetsByExercise(String exerciseName);
}
