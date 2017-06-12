package com.magical.demoservice.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sharanangadi on 12/06/17.
 */

public class MyIntentService extends IntentService {
    private static final String TAG = "MYAPP:MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        for (int i = 0; i < 100; i++) {
            Log.d(TAG, "inside service " + i);
            Toast.makeText(this, "inside service " + i, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MyIntentService onDestroy ");
        Toast.makeText(this, "MyIntentService onDestroy ", Toast.LENGTH_SHORT).show();
    }
}
