package com.example.unfitnotes1;



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

import com.example.unfitnotes1.databinding.ActivityAbsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Abs extends AppCompatActivity {
    private static final String TAG = "Abs";

    FloatingActionButton fab;
    private AppDataBase db;
    private ActivityAbsBinding binding;
    String [] AbsExercise = {
            "Ab Wheel Rollout",
            "Cable Crunch",
            "Crunches",
            "Crunch Machine",
            "Decline Crunch",
            "Hanging Knee Raise",
            "Plank",
            "Side Plank",
    };
    int categoryId = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abs);
        List<name_Exercise> exerciseList = new ArrayList<>();
        for (String exerciseName : AbsExercise) {
            name_Exercise exercise = new name_Exercise();
            exercise.setExercise_name(exerciseName);
            exercise.setCategory_id(categoryId);
            exerciseList.add(exercise);
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_abs);
        ListView listView = findViewById(R.id.listView);
        fab = findViewById(R.id.floatingActionButton5);
        db = AppDataBase.getInstance(getApplicationContext());
        new Thread(() -> {
            List<name_Exercise> existingExercise = db.NameExDao().getExercisesForCategory(1);

            if (existingExercise == null || existingExercise.isEmpty()) {
                db.NameExDao().insertAll(exerciseList);

            }
        }).start();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Abs.this, addSets.class);
                intent.putExtra("exercise_name", AbsExercise[position]);
                startActivity(intent);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AbsExercise);
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}