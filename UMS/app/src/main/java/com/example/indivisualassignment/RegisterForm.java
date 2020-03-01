package com.example.indivisualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterForm extends AppCompatActivity {
private EditText full_name;
private EditText user_name;
private EditText E_mail;
private EditText password;
private EditText mobile;
private RadioGroup radioGroup;
String selectedSex=null;
    RadioGroup group;
    RadioButton rb1;
    RadioButton rb2;

    UserDbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        full_name = findViewById(R.id.fullName);
        user_name = findViewById(R.id.userName);
        E_mail = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mobile = findViewById(R.id.password);
        helper = new UserDbHelper(this);


        group=findViewById(R.id.radioGroup);
        rb1=findViewById(R.id.male);
        rb2=findViewById(R.id.female);

    }

    public void register(View v){

        int id=group.getCheckedRadioButtonId();
        String sex="";
        if(id==R.id.male) {
            sex = "Male";
        }else if(id==R.id.male){
            sex="Female";
            Intent intent=new Intent(this,userActivity.class);
            startActivity(intent);

        }


        String name=full_name.getText().toString();
        String u_name=user_name.getText().toString();
        String email=E_mail.getText().toString();
        String pass=password.getText().toString();
        String mob=mobile.getText().toString();
//        String selectedSex=button.getText().toString();
        if(TextUtils.isEmpty(name)){
         full_name.setError("fullname is required");
         return;
        }
        if(TextUtils.isEmpty(u_name)){
            user_name.setError("User name is required");
            return;
        }
        if(TextUtils.isEmpty(email)){
            E_mail.setError("Email is required");
            return;
        }
        if(TextUtils.isEmpty(pass)){
            password.setError("password is required");
            return;
        }
        if(TextUtils.isEmpty(mob)){
            mobile.setError("phone number is required");
            return;
        }
        if(TextUtils.isEmpty(sex)){
            Toast.makeText(getApplicationContext(),"please choose your gender",Toast.LENGTH_SHORT).show();
            return;
        }
      // int id=1;
       boolean message= helper.insertData(name,u_name,email,pass,mob, sex);
       if(message){
           Toast.makeText(this,"Registered",Toast.LENGTH_SHORT).show();
       }
       else{
           Toast.makeText(this,"Not Registered...try again",Toast.LENGTH_SHORT).show();

       }

    }

}
