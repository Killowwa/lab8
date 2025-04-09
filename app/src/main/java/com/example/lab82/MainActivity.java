package com.example.lab82;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Intent foregroundServiceIntent;
    private Intent backgroundServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foregroundServiceIntent = new Intent(this, MyService.class);
        backgroundServiceIntent = new Intent(this, RandomCharacterService.class);
    }

    public void startForegroundService(View view) {
        ContextCompat.startForegroundService(this, foregroundServiceIntent);
    }

    public void stopForegroundService(View view) {
        stopService(foregroundServiceIntent);
    }

    public void startBackgroundService(View view) {
        startService(backgroundServiceIntent);
    }

    public void stopBackgroundService(View view) {
        stopService(backgroundServiceIntent);
    }

    public void nextActivity(View view) {
        startActivity(new Intent(this, MainActivity2.class));
    }
}
