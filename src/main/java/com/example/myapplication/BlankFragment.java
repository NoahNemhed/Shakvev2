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
import android.widget.TextView;
import androidx.fragment.app.Fragment;


public class BlankFragment extends Fragment implements SensorEventListener {

    TextView xPos, yPos,zPos;

    public BlankFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //Changes the text to current values.
        xPos.setText("xPos:" +  sensorEvent.values[0]);
        yPos.setText("yPos:" +  sensorEvent.values[1]);
        zPos.setText("zPos:" + sensorEvent.values[2]);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        xPos = view.findViewById(R.id.xPos);
        yPos = view.findViewById(R.id.yPos);
        zPos = view.findViewById(R.id.zPos);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}