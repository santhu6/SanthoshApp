package com.demmo.santhoshapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Button browse;
    EditText editurl;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        browse = findViewById(R.id.browsebtn);
        editurl = findViewById(R.id.editUrl);
        textView = findViewById(R.id.textView);

        Intent myIntent = getIntent();
        String message = myIntent.getStringExtra("name") + " - " + myIntent.getStringExtra("purpose");
        textView.setText(message);

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implicit intent for opening the browser
                String readUrl = editurl.getText().toString();
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
                Uri myurl = Uri.parse("https://" + readUrl);
                implicitIntent.setData(myurl);
                startActivity(implicitIntent);
                //sendActionIntent();
            }
        });
    }

    //implicit intent for send text messages
    public void sendActionIntent() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "sending message through sms");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
