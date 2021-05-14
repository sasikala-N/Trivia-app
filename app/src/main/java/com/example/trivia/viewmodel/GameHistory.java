package com.example.trivia.viewmodel;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class GameHistory {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String cricker;
    private String color;

//Constructore for room
    public GameHistory(int id, String name, String cricker, String color) {
        this.id = id;
        this.name = name;
        this.cricker = cricker;
        this.color = color;
    }
//constructore fro user
    @Ignore
    public GameHistory(String name, String cricker, String color) {
        this.name = name;
        this.cricker = cricker;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCricker() {
        return cricker;
    }

    public void setCricker(String cricker) {
        this.cricker = cricker;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
