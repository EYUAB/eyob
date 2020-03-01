package com.example.indivisualassignment;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPreferenceConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public sharedPreferenceConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit(); // check 1
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public boolean readLoginStatus() {
        boolean status=false;
       status=sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference),false);
       return status;

    }
}














