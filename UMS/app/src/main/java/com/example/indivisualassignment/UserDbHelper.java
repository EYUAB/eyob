package com.example.indivisualassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.indivisualassignment.userManagementReader.feedEntry;
//import static com.example.indivisualassignment.userManagementReader.feedEntry.COLUMN_ID;
import java.util.ArrayList;

import static com.example.indivisualassignment.userManagementReader.feedEntry.E_MAIL;
import static com.example.indivisualassignment.userManagementReader.feedEntry.FULL_NAME;
import static com.example.indivisualassignment.userManagementReader.feedEntry.GENDER;
import static com.example.indivisualassignment.userManagementReader.feedEntry.MOBILE;
import static com.example.indivisualassignment.userManagementReader.feedEntry.PASSWORD;
import static com.example.indivisualassignment.userManagementReader.feedEntry.TABLE_NAME;
import static com.example.indivisualassignment.userManagementReader.feedEntry.USER_NAME;

//+userManagementReader.feedEntry.COLUMN_ID
public class UserDbHelper extends SQLiteOpenHelper {
private static final String DATABASE_NAME="User_Management";
private static final int DATABASE_VERSION=1;
//    private static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE  user  ("+userManagementReader.feedEntry.COLUMN_ID
//                     + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    userManagementReader.feedEntry.FULL_NAME + " TEXT," +
//                    feedEntry.USER_NAME + " TEXT," + userManagementReader.feedEntry.E_MAIL + "TEXT," +
//                    userManagementReader.feedEntry.PASSWORD + " INTEGER," +
//                    userManagementReader.feedEntry.MOBILE + " INTEGER,"+ userManagementReader.feedEntry.GENDER+ "TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
    public UserDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        //SQLiteDatabase database=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"( full_name TEXT," +
                "user_name TEXT,E_mail TEXT primary key,password TEXT,mobile text,selectedSex TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }
    //int id,
    public boolean insertData(String name, String u_name, String email, String password, String mob, String selectedSex  ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_ID,id);
        contentValues.put(FULL_NAME,name);
        contentValues.put(USER_NAME,u_name);
        contentValues.put(E_MAIL,email);
        contentValues.put(PASSWORD,password);
        contentValues.put(MOBILE,mob);
        contentValues.put(GENDER,selectedSex);
        long result= db.insert(TABLE_NAME,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;


    }

    public int delete(String del){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME,"where E_MAIL=?",new String[]{del});
    }

    public Cursor usernamePassword() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select USER_NAME,PASSWORD from newUser", null);
        return res;
       // Toast.makeText(this,res,Toast.LENGTH_LONG).show();

    }
    public Cursor fetchAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from newUser",null);
        return cursor;
    }


}

