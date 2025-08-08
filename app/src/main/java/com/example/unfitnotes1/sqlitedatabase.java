package com.example.unfitnotes1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class sqlitedatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "workout.db";
    private static final int DATABASE_VERSION = 2;
    // Table Rows and columns
    public static final String TABLE_NAME = "workout_sets";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_EXERCISE = "exercise_name";
    public static final String COLUMN_REPS = "reps";
    public static final String COLUMN_WEIGHT = "weight";
    // Creation of it
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DATE + " TEXT NOT NULL," + COLUMN_EXERCISE + " TEXT NOT NULL, " + COLUMN_REPS + " INTEGER NOT NULL," + COLUMN_WEIGHT + " REAL NOT NULL)";

    public sqlitedatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addsets( String Today,String exercise_name, double reps, double weight) {
        String today = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, today);
        values.put(COLUMN_EXERCISE, exercise_name);
        values.put(COLUMN_REPS, reps);
        values.put(COLUMN_WEIGHT, weight);
        db.insert(TABLE_NAME, null, values);
        db.close();


    }

    public List<SetEntry> getSets() {
        List<SetEntry> sets = new ArrayList<>();
        String today = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date());
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE + " = ?" + "ORDER BY " + COLUMN_EXERCISE ;
        String[] selectionArgs = {today};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE));
                String exercise_name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EXERCISE));
                double reps = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_REPS));
                double weight = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_WEIGHT));
                String repval = reps + " reps";
                String weightval = weight + " kg";
                SetEntry setEntry = new SetEntry( exercise_name, repval, weightval);
                sets.add(setEntry);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return sets;

    }



}
