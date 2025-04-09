package com.example.lab82;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private Intent foregroundServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foregroundServiceIntent = new Intent(this, MyService.class);
    }

    public void startForegroundService(View view) {
        ContextCompat.startForegroundService(this, foregroundServiceIntent);
    }

    public void stopForegroundService(View view) {
        stopService(foregroundServiceIntent);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
