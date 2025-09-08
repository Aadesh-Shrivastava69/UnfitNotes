package com.example.unfitnotes1;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "new_workout_sets")
public class NewWorkoutSet {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "exercise_name")
    private String exerciseName;

    @ColumnInfo(name = "weight")
    private float weight;

    @ColumnInfo(name = "reps")
    private int reps;

    public NewWorkoutSet(String exerciseName, String date, float weight, int reps) {
        this.exerciseName = exerciseName;
        this.date = date;
        this.weight = weight;
        this.reps = reps;
    }

    public NewWorkoutSet(NewWorkoutSet newset) {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
