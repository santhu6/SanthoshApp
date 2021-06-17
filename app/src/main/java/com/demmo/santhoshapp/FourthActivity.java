package com.demmo.santhoshapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class FourthActivity extends AppCompatActivity/* implements View.OnClickListener */{

    Button camerabtn;
    ImageView imageView;
    int CAMERA_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        camerabtn = findViewById(R.id.camerabtn);
        imageView = findViewById(R.id.imageView);

        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE  && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap myImage = (Bitmap) extras.get("data");
            imageView.setImageBitmap(myImage);
        }else if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Invalid capture", Toast.LENGTH_LONG).show();
        }
    }

    /*@Override
    public void onClick(View view) {
        if (view.getId()==R.id.camerabtn){
            Toast.makeText(this, "Open Camera In 3rd Way", Toast.LENGTH_SHORT).show();
        }
    }*/

    /*public void openCamera(View view) {
        Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();
    }*/
}
