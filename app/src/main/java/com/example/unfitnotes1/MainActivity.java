package com.example.unfitnotes1;


import static androidx.fragment.app.FragmentManager.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.unfitnotes1.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Spinner spinner;
    PopupMenu popupMenu;
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> addSetLauncher;
    private HashMap<String, List<SetEntry>> workoutMap = new HashMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



        fab = findViewById(R.id.floatingActionButton2);
        popupMenu = new PopupMenu(this, fab);
        popupMenu.getMenu().add(Menu.NONE,0,0, "Settings");
        popupMenu.getMenu().add(Menu.NONE,1,1, "Copy Workout");
        popupMenu.getMenu().add(Menu.NONE,2,2, "Comment Workout");
        popupMenu.getMenu().add(Menu.NONE,3,3, "Time Workout");
        popupMenu.getMenu().add(Menu.NONE,4,4, "Share Workout");
        popupMenu.getMenu().add(Menu.NONE,5,5, "Body Tracker");
        popupMenu.getMenu().add(Menu.NONE,6,6, "Analysis");


        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG , "onClick: hello");
                Intent intent = new Intent(MainActivity.this, addWorkout.class);
                startActivity(intent);
            }
        });
        fab = findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, addWorkout.class);
                startActivity(intent1);
            }
        });
        fab =  findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: spinner");
                popupMenu.show();
            }
        });
        fab = findViewById(R.id.floatingActionButton4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, calendar.class);
                startActivity(intent2);
            }
        });




                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: resumed");
        Toast.makeText(this,"resumed",Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.textView);
        sqlitedatabase db = new sqlitedatabase(this);
        List<SetEntry> sets = db.getSets();
        if (!sets.isEmpty()) {
            String displayText = "Exercise: " + sets.get(0).exercise_name
                    + "\nReps: " + sets.get(0).reps
                    + "\nWeight: " + sets.get(0).weight;
            textView.setText(displayText);
        } else {
            textView.setText("No data available.");
        }




    }

}
