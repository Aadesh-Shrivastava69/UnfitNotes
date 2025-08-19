package com.example.unfitnotes1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface categoryExDao {
    @Insert
    void insertcategory(category_Exercise category_exercise);
    @Query("SELECT * FROM Exercise_Category")
    List<category_Exercise> getAllEx();

}
