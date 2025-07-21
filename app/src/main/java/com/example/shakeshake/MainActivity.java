package com.example.shakeshake;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.constraintlayout.widget.ConstraintLayout;  // <-- changed import
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor s;
    ConstraintLayout rl;  // <-- changed type to ConstraintLayout
    private float lastx, lasty, lastz;
    private int threshold = 500;
    private long lasttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rl = findViewById(R.id.main);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sm != null) {
            s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (s != null) {
            sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lasttime) > 100) {
            long diffTime = currentTime - lasttime;
            lasttime = currentTime;

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            float deltaX = x - lastx;
            float deltaY = y - lasty;
            float deltaZ = z - lastz;

            lastx = x;
            lasty = y;
            lastz = z;

            float speed = Math.abs(deltaX + deltaY + deltaZ) / diffTime * 10000;

            if (speed > threshold) {
                Random rnd = new Random();
                int color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                rl.setBackgroundColor(color);
            }
        }
    }
}
