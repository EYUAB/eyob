package com.example.indivisualassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class userActivity extends AppCompatActivity {
    sharedPreferenceConfig preferenceConfig;
    private RecyclerView recyclerView;
    UserDbHelper userDbHelper;
    ArrayList<UserModel> userModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        preferenceConfig=new sharedPreferenceConfig(getApplicationContext());
        userDbHelper = new UserDbHelper(this);
        recyclerView=findViewById(R.id.recycler_view);
        userModels=new ArrayList<>();
        fetch();
        fetchData f=new fetchData(userModels,getApplicationContext());
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(f);
    }
    public void logoutUser(){
        preferenceConfig.writeLoginStatus(false);
        Intent intent=new Intent(userActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void fetch(){
        Cursor data = userDbHelper.fetchAllData();
        while (data.moveToNext()) {
            userModels.add(new UserModel(data.getString(0),data.getString(1)
                    ,data.getString(2),data.getString(3),data.getString(4),data.getString(5)));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        logoutUser();
        return super.onOptionsItemSelected(item);
    }
}
