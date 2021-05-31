package com.angon.tree_of_history;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PeopleDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PeopleDatabase.db";
    private static final String TABLE_NAME = "PeopleData";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_SURNAME = "Surname";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_INFORMATION = "Information";
    private static final String COLUMN_PHOTO_PATH = "PhotoPath";
    private static final String COLUMN_GENERATION = "Generation";

    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_NAME = 1;
    private static final int NUM_COLUMN_SURNAME = 2;
    private static final int NUM_COLUMN_AGE = 3;
    private static final int NUM_COLUMN_INFORMATION = 4;
    private static final int NUM_COLUMN_PHOTO_PATH = 5;
    private static final int NUM_COLUMN_GENERATION = 6;

    public PeopleDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String peopleData = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SURNAME + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_INFORMATION + " TEXT, " +
                COLUMN_PHOTO_PATH + " TEXT, " +
                COLUMN_GENERATION + " INTEGER); ";
        db.execSQL(peopleData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}