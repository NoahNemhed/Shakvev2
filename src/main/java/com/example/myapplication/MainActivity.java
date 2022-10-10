package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Declares 2 buttons for each fragment layout.
            Button fragment1 = (Button) findViewById(R.id.btn1);
            Button fragment2 = (Button) findViewById(R.id.btn2);
            //Lay out 1
            fragment1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    BlankFragment blankFragment = new BlankFragment();
                    // Begin the transaction
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    // Replace the contents of the container with the new fragment
                    ft.replace(R.id.fragment1, blankFragment);
                    // Complete the changes added above
                    ft.commit();
                }
            });

            //Layout 2
            fragment2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    BlankFragment2 blankFragment2 = new BlankFragment2();
                    // Begin the transaction
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    // Replace the contents of the container with the new fragment
                    ft.replace(R.id.fragment1, blankFragment2);
                    // Complete the changes added above
                    ft.commit();
                }
            });

        }
    }