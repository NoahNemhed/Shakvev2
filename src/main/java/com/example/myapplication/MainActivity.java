package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";

    //Declaring TextView and ImageView Variables
    TextView xPos, yPos,zPos;
    ImageView imageView;

    //Declaring SensorManager and Accelerometer.
    private SensorManager sensorManager;
    Sensor accelerometer;

    //Variable to check if phones rotated.
    boolean rotated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xPos = findViewById(R.id.xPos);
        yPos = findViewById(R.id.yPos);
        zPos = findViewById(R.id.zPos);
        imageView = findViewById(R.id.imageView);



        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //Changes the text to current values.
        xPos.setText("xPos:" +  sensorEvent.values[0]);
        yPos.setText("yPos:" +  sensorEvent.values[1]);
        zPos.setText("zPos:" + sensorEvent.values[2]);

        //Checks if phones rotated
        if(rotated((int) Math.abs(sensorEvent.values[0]),(int) Math.abs(sensorEvent.values[1])) && (rotated == false)) {
            if((int) sensorEvent.values[0] > 0){
                imageView.setRotation(90f);
            }else{
                imageView.setRotation(-90f);
            }
            rotated = true;
        }
        //Checks if phones not rotated
        if(!rotated((int) Math.abs(sensorEvent.values[0]),(int) Math.abs(sensorEvent.values[1])) && (rotated == true)) {
            imageView.setRotation(0f);
            rotated = false;
        }



    }

    public boolean rotated(int x, int y){
        if(x < 0 || x > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}