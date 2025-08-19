package com.example.unfitnotes1;

import android.annotation.SuppressLint;
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

import com.example.unfitnotes1.databinding.ActivityAddWorkoutBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class addWorkout extends AppCompatActivity {
    private ActivityAddWorkoutBinding binding;
    FloatingActionButton fab1;
    private AppDataBase db;
    private static final String TAG = "addWorkout";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_workout);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_workout);
        ListView listView = findViewById(R.id.exercise_categorylistview);
        fab1 = findViewById(R.id.floatingActionButton5);
        db = AppDataBase.getInstance(getApplicationContext());

        new Thread(() -> {
            List<category_Exercise> existingTypes = db.CategoryExDao().getAllEx();

            if (existingTypes == null || existingTypes.isEmpty()) {
                db.CategoryExDao().insertcategory(new category_Exercise("Abs"));
                db.CategoryExDao().insertcategory(new category_Exercise("Back"));
                db.CategoryExDao().insertcategory(new category_Exercise("Biceps"));
                db.CategoryExDao().insertcategory(new category_Exercise("Chest"));
                db.CategoryExDao().insertcategory(new category_Exercise("Legs"));
                db.CategoryExDao().insertcategory(new category_Exercise("Shoulders"));
                db.CategoryExDao().insertcategory(new category_Exercise("Triceps"));
            }
        }).start();



        new Thread(() ->{
            List<category_Exercise> fetchedTypes = db.CategoryExDao().getAllEx();
            Log.d(TAG, "Fetched size: " + fetchedTypes.size()); // debug

            List<String> typeNames = new ArrayList<>();
            for (category_Exercise et : fetchedTypes) {
                typeNames.add(et.getExercise_type());
            }

            runOnUiThread(() -> {
                Log.d(TAG, "TypeNames: " + typeNames);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        addWorkout.this,
                        android.R.layout.simple_list_item_1,
                        typeNames
                );
                listView.setAdapter(adapter);
            });
        }).start();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                if (selectedItem.equals("Abs")) {
                    Intent intent = new Intent(addWorkout.this, Abs.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Back")) {
                    Intent intent = new Intent(addWorkout.this, Back.class);
                    startActivity(intent);

                } else if (selectedItem.equals("Biceps")) {
                    Intent intent = new Intent(addWorkout.this, biceps.class);
                    startActivity(intent);

                }
                else if (selectedItem.equals("Chest")) {
                    Intent intent = new Intent(addWorkout.this, Chest.class);
                    startActivity(intent);

                }
                else if (selectedItem.equals("Legs")) {
                    Intent intent = new Intent(addWorkout.this,Legs.class);
                    startActivity(intent);

                }
                else if (selectedItem.equals("Triceps")) {
                    Intent intent = new Intent(addWorkout.this,Tricep.class);
                    startActivity(intent);

                }
                else if (selectedItem.equals("Shoulders")) {
                    Intent intent = new Intent(addWorkout.this,Shoulder.class);
                    startActivity(intent);

                }



            }
        });

        fab1.setOnClickListener(v -> {
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}