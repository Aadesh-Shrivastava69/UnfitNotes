package com.example.unfitnotes1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercise",
        foreignKeys = @ForeignKey(entity = category_Exercise.class,
                parentColumns = "id",
                childColumns = "category_id",
                onDelete = ForeignKey.CASCADE))
public class name_Exercise {
    @PrimaryKey(autoGenerate = true)
    private int exercise_id;
    private String Exercise_name;
    @ColumnInfo(name = "category_id")
    private int category_id;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getExercise_name() {
        return Exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        Exercise_name = exercise_name;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }
}
