package com.example.unfitnotes1;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import com.example.unfitnotes1.databinding.ActivityAddSetsBinding;

public class addSets extends AppCompatActivity {
    private ActivityAddSetsBinding binding;
    Button button;
    TextView textView;
    EditText editText;
    private AppDataBase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_sets);
        String exercise_name = getIntent().getStringExtra("exercise_name");
        String today = new java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault()).format(new java.util.Date());
        db = AppDataBase.getInstance(getApplicationContext());
        button= findViewById(R.id.button16);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
               int reps = Integer.parseInt((binding.editTextNumberDecimal).getText().toString());
                float weight = Float.parseFloat((binding.editTextNumberDecimal2).getText().toString());
                new Thread(() -> {
                    db.newWorkoutSetDao().insert(new NewWorkoutSet(exercise_name,today,weight,reps));
                }).start();


                Intent intent = new Intent(addSets.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
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