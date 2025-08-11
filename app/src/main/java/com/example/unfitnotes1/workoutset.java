package com.example.unfitnotes1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workout_sets")
public class workoutset{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String date;
    private String exercise_name;
    private int reps;
    private double weight;
    private static int counts = 0;

    public workoutset(int id, String date, String exercise_name,double weight,  int reps) {
        this.id = ++ counts ;
        this.date = date;
        this.exercise_name = exercise_name;
        this.weight = weight;
        this.reps = reps;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}