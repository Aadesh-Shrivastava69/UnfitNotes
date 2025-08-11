package com.example.unfitnotes1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class SetEntryAdapter extends ArrayAdapter<workoutset> {
    private Context context;
    private List<workoutset> sets;


    public SetEntryAdapter(@NonNull Context context, @NonNull List<workoutset> sets) {
        super(context, 0, sets);
        this.context = context;
        this.sets = sets;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        }
        workoutset set = sets.get(position);
        TextView exerciseNameTextView = convertView.findViewById(R.id.textViewExerciseName);
        TextView repsTextView = convertView.findViewById(R.id.textViewReps);
        TextView weightTextView = convertView.findViewById(R.id.textViewWeight);
        exerciseNameTextView.setText(set.getExercise_name());
        repsTextView.setText(String.valueOf(set.getReps()));
        weightTextView.setText(String.valueOf(set.getWeight()));
        return convertView;
    }



}
