package com.example.unfitnotes1;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    private static AppDataBase db;
    @Override
    public void onCreate() {
        super.onCreate();
         db = Room.databaseBuilder(getApplicationContext(),
                        AppDataBase.class, "unfitnotes_db")
                .fallbackToDestructiveMigration()
                .build();
    }
    public static  AppDataBase getdatabase(){
        return db;
    }
}
