package com.example.lab82;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class RandomCharacterService extends Service {

    private boolean isRunning = false;
    private static final String TAG = "RandomService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRunning = true;

        new Thread(() -> {
            while (isRunning) {
                try {
                    Thread.sleep(1000);

                    int randomNumber = new Random().nextInt(100); // от 0 до 99

                    Log.d(TAG, "Generated number: " + randomNumber);

                    Intent broadcastIntent = new Intent("com.example.lab82.RANDOM_NUMBER");
                    broadcastIntent.putExtra("number", randomNumber);
                    sendBroadcast(broadcastIntent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
