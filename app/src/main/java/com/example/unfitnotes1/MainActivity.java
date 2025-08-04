package com.example.unfitnotes1;


import static androidx.fragment.app.FragmentManager.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.unfitnotes1.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Spinner spinner;
    PopupMenu popupMenu;
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;


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
}