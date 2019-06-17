package com.example.wearableapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AccelerometerActivity extends AppCompatActivity {

    private TextView tvShowAxis;
    private SensorManager sensorManager;

    SensorEventListener sel = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            String xAxis ="x : " + values[0];
            String yAxis ="y : " + values[1];
            String zAxis ="z : " + values[2];
            tvShowAxis.setText(xAxis  + " " + yAxis + " " + zAxis);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_sensor);

        tvShowAxis = findViewById(R.id.tvShowAxis);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

       Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if(sensor!=null)
        {
            sensorManager.registerListener(sel,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
        else
        {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show();
        }
    }
}