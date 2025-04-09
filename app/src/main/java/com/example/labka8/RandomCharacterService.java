package com.example.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.Random;

public class RandomCharacterService extends Service {
    private boolean isRandomGeneratorOn;
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final String TAG = "RandomCharacterService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
        isRandomGeneratorOn = true;

        new Thread(() -> startRandomGenerator()).start();

        return START_STICKY;
    }

    private void startRandomGenerator() {
        while (isRandomGeneratorOn) {
            try {
                Thread.sleep(1000);
                int randomIdx = new Random().nextInt(alphabet.length);
                char myRandomCharacter = alphabet[randomIdx];
                Log.i(TAG, "Random Character: " + myRandomCharacter);

                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction("my.custom.action.tag.lab6");
                broadcastIntent.putExtra("randomCharacter", myRandomCharacter);
                sendBroadcast(broadcastIntent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void stopRandomGenerator() {
        isRandomGeneratorOn = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRandomGenerator();
        Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
