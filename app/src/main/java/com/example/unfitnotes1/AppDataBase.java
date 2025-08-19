package com.example.unfitnotes1;

import android.content.Context;

import androidx.room.Database;

import com.example.unfitnotes1.DAO;
import com.example.unfitnotes1.workoutset;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {workoutset.class, category_Exercise.class}, version = 4)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DAO dao();
    private static volatile AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDataBase.class, "my_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    public abstract categoryExDao CategoryExDao();
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

}