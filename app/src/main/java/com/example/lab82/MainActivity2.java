package com.example.lab82;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Intent backgroundServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backgroundServiceIntent = new Intent(this, RandomCharacterService.class);

        Button startButton = findViewById(R.id.button_start_background);
        Button stopButton = findViewById(R.id.button_stop_background);

        startButton.setOnClickListener(v -> startService(backgroundServiceIntent));
        stopButton.setOnClickListener(v -> stopService(backgroundServiceIntent));
    }
}

