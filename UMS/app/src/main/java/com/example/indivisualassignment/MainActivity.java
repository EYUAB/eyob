package com.example.indivisualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private EditText userName;
    private EditText password;
    private sharedPreferenceConfig preferenceConfig;
    UserDbHelper userDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceConfig = new sharedPreferenceConfig(getApplicationContext());
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        userDbHelper = new UserDbHelper(this);
        if (preferenceConfig.readLoginStatus()) {
            Intent intent = new Intent(MainActivity.this, userActivity.class);
            startActivity(intent);
            finish();

        }

    }

    public void loginUser(View view) {
        String name = userName.getText().toString();
        String pass = password.getText().toString();

        Cursor cursor = userDbHelper.usernamePassword();
        boolean x =false;
        while (cursor.moveToNext()) {

            if (name.equals(cursor.getString(0)) && pass.equals(cursor.getString(1))) {
                Intent intent = new Intent(MainActivity.this, userActivity.class);
                startActivity(intent);
                preferenceConfig.writeLoginStatus(true);
                x=true;
                finish();

            }
            }

        if (!x){
            Toast.makeText(getApplicationContext(), "login faild...try again", Toast.LENGTH_SHORT).show();
            userName.setText("");
            password.setText("");


        }}
        public void toRegister (View view){
            Intent intent = new Intent(MainActivity.this, RegisterForm.class);
            startActivity(intent);

        }

    }



