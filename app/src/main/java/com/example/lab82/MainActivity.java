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
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(this, MyService.class);
    }

    public void startService(View view) {
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    public void stopService(View view) {
        stopService(serviceIntent);
    }

    public void nextActivity(View view) {
        startActivity(new Intent(this, MainActivity2.class));
    }
}
