package com.example.unfitnotes1;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class SetEntry {
    public String exercise_name;

    public String reps;
    public String weight;


    public SetEntry(String exercise_name,String reps, String weight) {
        this.exercise_name = exercise_name;
        this.reps = reps;
        this.weight = weight;

    }


}
