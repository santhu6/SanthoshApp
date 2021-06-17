package com.demmo.santhoshapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
    Button btn, btn2;

    boolean changeText = false;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        btn = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeText) {
                    textView1.setText("Welcome !");
                    changeText=false;
                }else{
                    textView1.setText("Cogratulations !");
                    changeText=true;
                }
                textView2.setText(String.valueOf(--count));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  in = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(in);
            }
        });
    }


}