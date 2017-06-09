package com.magical.demoservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sharanangadi on 09/06/17.
 */

public class ServiceDemo extends Service {
    private static final String TAG = "MYAPP:Service";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        for (int i = 0; i < 100; i++) {
            Log.d(TAG, "inside service " + i);
            Toast.makeText(this, "inside service " + i, Toast.LENGTH_SHORT).show();
        }

        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside onDestroy");
        Toast.makeText(this, "inside onDestroy ", Toast.LENGTH_SHORT).show();
    }
}
