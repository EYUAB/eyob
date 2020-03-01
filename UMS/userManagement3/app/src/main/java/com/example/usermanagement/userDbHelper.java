package com.example.usermanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class userDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + feedReaderContract.feedEntry.TABLE_NAME + " (" +
                    feedReaderContract.feedEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    feedReaderContract.feedEntry.COLUMN2 + " TEXT," +
                    feedReaderContract.feedEntry.COLUMN3 + " TEXT," + feedReaderContract.feedEntry.COLUMN4 + "TEXT," +
                    feedReaderContract.feedEntry.COLUMN5 + " INTEGER," +
                    feedReaderContract.feedEntry.COLUMN6 + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + feedReaderContract.feedEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user_management.db";

    public userDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

