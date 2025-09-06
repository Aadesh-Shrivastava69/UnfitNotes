package com.example.unfitnotes1;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.example.unfitnotes1.databinding.ActivityBackBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Back extends AppCompatActivity {
    private static final String TAG = "Back";
    private ActivityBackBinding binding;
    FloatingActionButton fab2;
    private AppDataBase db;
    ListView listview;
    String [] BackExercises = {
            "Barbell Row",
            "Barbell Shrug",
            "Chin Up",
            "Deadlift",
            "Dumbbell Rows",
            "Lat Pulldown",
            "Pull Up",
            "Rope Pullover",
            "Seated Cable Row",
            "T-Bar Row"
    };
    int categoryId = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_back);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_back);
        listview = findViewById(R.id.listView);
        db = AppDataBase.getInstance(getApplicationContext());
        List<name_Exercise> exerciseList = new ArrayList<>();
        for (String exerciseName : BackExercises) {
            name_Exercise exercise = new name_Exercise();
            exercise.setExercise_name(exerciseName);
            exercise.setCategory_id(categoryId);
            exerciseList.add(exercise);
        }
        fab2 = findViewById(R.id.floatingActionButton5);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        new Thread(() -> {
            List<name_Exercise> existingExercise = db.NameExDao().getExercisesForCategory(2);

            if (existingExercise == null || existingExercise.isEmpty()) {
                db.NameExDao().insertAll(exerciseList);

            }
        }).start();
        // ui update
        new Thread(() ->{
            List<name_Exercise> fetchedTypes = db.NameExDao().getExercisesForCategory(2);
            Log.d(TAG, "Fetched size: " + fetchedTypes.size()); // debug

            List<String> typeNames = new ArrayList<>();
            for (name_Exercise et : fetchedTypes) {
                typeNames.add(et.getExercise_name());
            }

            runOnUiThread(() -> {
                Log.d(TAG, "TypeNames: " + typeNames);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        Back.this,
                        android.R.layout.simple_list_item_1,
                        typeNames
                );
                listview.setAdapter(adapter);
            });
        }).start();


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Back.this, addSets.class);
                intent.putExtra("exercise_name", BackExercises[position]);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}