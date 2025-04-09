package com.example.lab82;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class RandomCharacterService extends Service {

    private boolean isRandomGeneratorOn = false;
    private static final String TAG = "RandomCharacterService";

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Background Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRandomGeneratorOn = true;

        // Запускаем фоновый поток для генерации случайных символов
        new Thread(new Runnable() {
            @Override
            public void run() {
                startRandomGenerator();
            }
        }).start();

        return START_STICKY;
    }

    private void startRandomGenerator() {
        while (isRandomGeneratorOn) {
            try {
                Thread.sleep(1000);
                char randomCharacter = generateRandomCharacter();
                Log.i(TAG, "Generated character: " + randomCharacter);
            } catch (InterruptedException e) {
                Log.i(TAG, "Thread Interrupted.");
            }
        }
    }

    private char generateRandomCharacter() {
        // Генерация случайного символа (буквы)
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int randomIdx = new Random().nextInt(alphabet.length);
        return alphabet[randomIdx];
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRandomGeneratorOn = false;
        Toast.makeText(this, "Background Service Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
