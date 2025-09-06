package com.example.unfitnotes1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface nameExDao {
    @Insert
    void insert(name_Exercise exercise);
    @Insert
    void insertAll(List<name_Exercise> exercises);
    @Query("SELECT * FROM exercise WHERE category_id = :categoryId")
    List<name_Exercise> getExercisesForCategory(int categoryId);
}