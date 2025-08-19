package com.example.unfitnotes1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Exercise_Category")

public class category_Exercise {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Exercise_type;
    public category_Exercise() {
    }

    public category_Exercise(String exercise_type) {
        Exercise_type = exercise_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise_type() {
        return Exercise_type;
    }

    public void setExercise_type(String exercise_type) {
        this.Exercise_type = exercise_type;
    }
}
