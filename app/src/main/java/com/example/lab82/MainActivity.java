package com.example.lab82;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private Intent foregroundServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foregroundServiceIntent = new Intent(this, MyService.class);

        Button startButton = findViewById(R.id.button_start_foreground);
        Button stopButton = findViewById(R.id.button_stop_foreground);
        Button nextButton = findViewById(R.id.button_next);

        startButton.setOnClickListener(v ->
                ContextCompat.startForegroundService(this, foregroundServiceIntent)
        );

        stopButton.setOnClickListener(v ->
                stopService(foregroundServiceIntent)
        );

        nextButton.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity2.class))
        );
    }
}
