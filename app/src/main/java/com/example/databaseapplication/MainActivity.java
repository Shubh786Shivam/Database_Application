package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase eventDatabase;
    //SQLiteDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
//        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
//        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Shubham', 24)");
//        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Shikhar', 21)");
//
//        Cursor cu = myDatabase.rawQuery("SELECT * FROM users", null);
//        int nameIndex = cu.getColumnIndex("name");
//        int ageIndex = cu.getColumnIndex("age");
//
//        cu.moveToFirst();
//        while(!cu.isAfterLast()){
//            Log.i("Name", cu.getString(nameIndex));
//            Log.i("Age", cu.getString(ageIndex));
//            cu.moveToNext();
//        }
        eventDatabase = this.openOrCreateDatabase("Event", MODE_PRIVATE, null);
        eventDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, year INT(4))");
        eventDatabase.execSQL("INSERT INTO events (event, year) VALUES ('Spanish Flu', 1918)");
        eventDatabase.execSQL("INSERT INTO events (event, year) VALUES ('Kakori', 1925)");

        Cursor c = eventDatabase.rawQuery("SELECT * FROM events", null);
        int eventIndex = c.getColumnIndex("event");
        int yearIndex = c.getColumnIndex("year");
        c.moveToFirst();
        while(!c.isAfterLast()){
            Log.i("Event", c.getString(eventIndex));
            Log.i("Year", c.getString(yearIndex));
            c.moveToNext();
        }

    }
}