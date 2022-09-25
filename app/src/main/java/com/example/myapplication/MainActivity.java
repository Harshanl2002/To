package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    CameraManager cam;
    String id;
    Boolean state=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=findViewById(R.id.cl);
        layout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(state==false) {
                    try {
                        cam = (CameraManager) getSystemService(CAMERA_SERVICE);
                        id = cam.getCameraIdList()[0];
                        cam.setTorchMode(id, !state);
                        layout.setBackgroundResource(R.drawable.on);
                        state=true;

                    }catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        cam = (CameraManager) getSystemService(CAMERA_SERVICE);
                        id = cam.getCameraIdList()[0];
                        cam.setTorchMode(id, !state);
                        layout.setBackgroundResource(R.drawable.off);
                        state=false;

                    }catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}