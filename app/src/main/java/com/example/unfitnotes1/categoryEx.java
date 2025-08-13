package com.example.unfitnotes1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ex_Category")

public class categoryEx {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Extype;

    public categoryEx(String extype) {
        Extype = extype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtype() {
        return Extype;
    }

    public void setExtype(String extype) {
        Extype = extype;
    }
}
