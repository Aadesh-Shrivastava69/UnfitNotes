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
import com.example.unfitnotes1.databinding.ActivityShoulderBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Shoulder extends AppCompatActivity {
    FloatingActionButton fab;
    private ActivityShoulderBinding  binding;

    String [] ShoulderExercises = {
            "Arnold Dumbbell Press",
            "Barbell Overhead Press",
            "Front Dumbbell Raises",
            "Lateral Dumbbell Raises",
            "Rear Delt Flyes",
            "Dumbbell OHP",
            "Cable Face Pulls"

    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shoulder);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shoulder);
        ListView listView;
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Shoulder.this, addSets.class);
                intent.putExtra("exercise_name", ShoulderExercises[position]);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoulderExercises);
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