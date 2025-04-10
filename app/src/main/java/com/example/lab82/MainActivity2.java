package com.example.lab82;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Intent backgroundServiceIntent;
    private TextView numberTextView;

    private BroadcastReceiver numberReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int number = intent.getIntExtra("number", -1);
            numberTextView.setText("Случайное число: " + number);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backgroundServiceIntent = new Intent(this, RandomCharacterService.class);

        Button startButton = findViewById(R.id.button_start_background);
        Button stopButton = findViewById(R.id.button_stop_background);
        Button backButton = findViewById(R.id.button_back_foreground);
        numberTextView = findViewById(R.id.text_random_number);

        startButton.setOnClickListener(v -> startService(backgroundServiceIntent));
        stopButton.setOnClickListener(v -> stopService(backgroundServiceIntent));
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity2.this, MainActivity.class));
            finish();
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(numberReceiver, new IntentFilter("com.example.lab82.RANDOM_NUMBER"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(numberReceiver);
    }

}
