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
import com.example.unfitnotes1.databinding.ActivityLegsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Legs extends AppCompatActivity {
    FloatingActionButton fab;
    private AppDataBase db;
    private ActivityLegsBinding binding;
    String [] LegExercise = {
            "Leg Press",
            "Hamstring Curls",
            "Legs Extensions",
            "Deadlift",
            "Calf Raises",
            "Squats",
            "Hack Squat",
            "Adducttors",
            "Abductors"

    };
    int categoryId = 5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_legs);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_legs);
        db = AppDataBase.getInstance(getApplicationContext());
        List<name_Exercise> exerciseList = new ArrayList<>();
        for (String exerciseName : LegExercise) {
            name_Exercise exercise = new name_Exercise();
            exercise.setExercise_name(exerciseName);
            exercise.setCategory_id(categoryId);
            exerciseList.add(exercise);
        }
        new Thread(() -> {
            List<name_Exercise> existingExercise = db.NameExDao().getExercisesForCategory(5);

            if (existingExercise == null || existingExercise.isEmpty()) {
                db.NameExDao().insertAll(exerciseList);

            }
        }).start();
        ListView listView;
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Legs.this, addSets.class);
                intent.putExtra("exercise_name", LegExercise[position]);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LegExercise);
        listView.setAdapter(adapter);
        fab = findViewById(R.id.floatingActionButton5);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}