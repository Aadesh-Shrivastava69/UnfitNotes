package com.example.unfitnotes1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.unfitnotes1.databinding.ActivityBicepsBinding;
import com.example.unfitnotes1.databinding.ActivityTricepBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Tricep extends AppCompatActivity {
    FloatingActionButton fab;
    private AppDataBase db;
    private ActivityTricepBinding binding;

    String [] TricepExercises = {
            "Cable Overhead Extensions",
            "Rope Push Down",
            "Skull Crusher",
            "Dumbbell Overhead Extensions",
            "Ring Dip",
            "Lying Tricep Extensions"

    };
    int categoryId = 7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tricep);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tricep);
        ListView listView;
        listView = findViewById(R.id.listView);
        db = AppDataBase.getInstance(getApplicationContext());
        List<name_Exercise> exerciseList = new ArrayList<>();
        for (String exerciseName : TricepExercises) {
            name_Exercise exercise = new name_Exercise();
            exercise.setExercise_name(exerciseName);
            exercise.setCategory_id(categoryId);
            exerciseList.add(exercise);
        }
        new Thread(() -> {
            List<name_Exercise> existingExercise = db.NameExDao().getExercisesForCategory(7);

            if (existingExercise == null || existingExercise.isEmpty()) {
                db.NameExDao().insertAll(exerciseList);

            }
        }).start();


        // ui update
        new Thread(() ->{
            List<name_Exercise> fetchedTypes = db.NameExDao().getExercisesForCategory(7);


            List<String> typeNames = new ArrayList<>();
            for (name_Exercise et : fetchedTypes) {
                typeNames.add(et.getExercise_name());
            }

            runOnUiThread(() -> {

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        Tricep.this,
                        android.R.layout.simple_list_item_1,
                        typeNames
                );
                listView.setAdapter(adapter);

            });
        }).start();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Tricep.this, addSets.class);
                intent.putExtra("exercise_name", TricepExercises[position]);
                startActivity(intent);
            }
        });


        fab = findViewById(R.id.floatingActionButton5);
        fab.setOnClickListener(v -> finish());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}