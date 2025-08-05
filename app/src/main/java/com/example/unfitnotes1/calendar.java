package com.example.unfitnotes1;

import static com.example.unfitnotes1.R.id.revert2;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.databinding.DataBindingUtil;

import com.example.unfitnotes1.databinding.ActivityCalendarBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;


public class calendar extends AppCompatActivity {
    private static final String TAG = "calendar";
    private ActivityCalendarBinding binding;
    FloatingActionButton fab;
    CalendarView calendarView;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar);
       fab= findViewById(R.id.revert2);
       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
        fab = findViewById(R.id.floatingActionButton6);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(calendar.this, "Selected Today", Toast.LENGTH_SHORT).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}