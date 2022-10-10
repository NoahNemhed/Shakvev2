package com.example.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;


public class BlankFragment2 extends Fragment implements SensorEventListener {


    ImageView imageView;
    boolean rotated;

    public BlankFragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

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

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        imageView = view.findViewById(R.id.image);
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