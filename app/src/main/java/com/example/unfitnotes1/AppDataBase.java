package com.example.unfitnotes1;

import androidx.room.Database;

import com.example.unfitnotes1.DAO;
import com.example.unfitnotes1.workoutset;
import androidx.room.RoomDatabase;

@Database(entities = {workoutset.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DAO dao();

}