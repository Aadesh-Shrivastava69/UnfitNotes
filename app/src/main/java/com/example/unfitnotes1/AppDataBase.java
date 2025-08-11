package com.example.unfitnotes1;

import androidx.room.Database;

import com.example.unfitnotes1.DAO;
import com.example.unfitnotes1.workoutset;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {workoutset.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DAO dao();
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

}