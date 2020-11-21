package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText username,password,repass;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username=findViewById(R.id.username);
        repass=findViewById(R.id.repass);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String Fusername = username.getText().toString();
                String Frepass = repass.getText().toString();
                String Fpassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(Fusername + Fpassword + "data", "Welcome" +"\n" + Fusername +"\n" + "You have been"+"\n" + "Successfully"+"\n" + "Logged In");
                editor.commit();

                Intent Login = new Intent(Register.this, Login.class);
                startActivity(Login);

            }
        });



    }


}
