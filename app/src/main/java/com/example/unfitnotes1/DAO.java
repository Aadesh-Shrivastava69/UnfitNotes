package com.example.unfitnotes1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {
    @Insert
    void insert(workoutset workoutset);
    @Update
    void update(workoutset workoutset);
    @Delete
    void delete(workoutset workoutset);
    @Query("SELECT * FROM workout_sets")
    List<workoutset> getAll();

    @Query("SELECT * FROM workout_sets WHERE date = :date")
    List<workoutset> getSetsByDate(String date);
    @Query("SELECT * FROM workout_sets ORDER BY exercise_name = :exercise_name")
    List<workoutset> getSetsByExercise(String exercise_name);
}
