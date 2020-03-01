package com.example.indivisualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {
  private TextView fname;
    private TextView u_name;
    private TextView e_mail;
    private TextView mob;
    private TextView gend;
    RadioGroup group;
    RadioButton rb1;
    RadioButton rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        fname=findViewById(R.id.full_name);
        u_name=findViewById(R.id.user_name);
        e_mail=findViewById(R.id.E_mail);
        mob=findViewById(R.id.password);
        gend=findViewById(R.id.gender);



        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        UserModel userModel=(UserModel) bundle.get("user");
       fname.setText(userModel.getFullname());
       u_name.setText(userModel.getUsername());
       e_mail.setText(userModel.getEmail());
       mob.setText(userModel.getPhone());
       gend.setText(userModel.getGender());


    }
}
