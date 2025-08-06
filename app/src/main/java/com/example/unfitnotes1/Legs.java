package com.example.unfitnotes1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
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

public class Legs extends AppCompatActivity {
    FloatingActionButton fab;
    private ActivityLegsBinding binding;
    String [] BicepExercises = {
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_legs);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_legs);
        ListView listView;
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BicepExercises);
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