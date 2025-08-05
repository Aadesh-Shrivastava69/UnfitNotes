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

import com.example.unfitnotes1.databinding.ActivityAddWorkoutBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addWorkout extends AppCompatActivity {
    private ActivityAddWorkoutBinding binding;
    FloatingActionButton fab1;


    private static final String TAG = "addWorkout";
    String [] ExerciseType = {
            "Abs",
            "Back",
            "Biceps",
            "Chest",
            "Cardio",
            "Legs",
            "Shoulders",
            "Triceps"

    };






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_workout);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_workout);
        fab1 = findViewById(R.id.floatingActionButton5);
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ExerciseType);
        listView.setAdapter(adapter);
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