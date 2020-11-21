package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText usrnm,psswrd;
    Button login,register;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usrnm=findViewById(R.id.usrnm);
        psswrd=findViewById(R.id.psswrd);

        login=findViewById(R.id.login);
        register=findViewById(R.id.register);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  user = usrnm.getText().toString();
                String  pass = psswrd.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

                String userD = preferences.getString(user + pass +  "data" , "Username or Password" +"\n" + "is Incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userD);
                editor.commit();

                Intent L = new Intent(Login.this, Display.class);
                startActivity(L);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });



    }
}
