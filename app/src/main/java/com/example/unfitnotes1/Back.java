package com.example.unfitnotes1;

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

import com.example.unfitnotes1.databinding.ActivityBackBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Back extends AppCompatActivity {
    private static final String TAG = "Back";
    private ActivityBackBinding binding;
    FloatingActionButton fab2;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_back);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_back);
        fab2 = findViewById(R.id.floatingActionButton5);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listview = findViewById(R.id.listView);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BackExercises);
        listview.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}