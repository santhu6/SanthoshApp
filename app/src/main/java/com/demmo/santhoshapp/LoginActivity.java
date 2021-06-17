package com.demmo.santhoshapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity<LoginActivityActivity> extends AppCompatActivity {

    EditText userIdField,passwordField;
    Button login,button2;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userIdField = findViewById(R.id.userId);
        passwordField = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        button2 =findViewById(R.id.login_btn2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userIdField.getText().toString();
                String password = passwordField.getText().toString();

                Toast.makeText(LoginActivity.this, username+" - "+password, Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this,LoginActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
