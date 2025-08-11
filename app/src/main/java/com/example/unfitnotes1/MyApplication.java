package com.example.unfitnotes1;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class,"unfitnotes_db").fallbackToDestructiveMigration().build();
    }
}
