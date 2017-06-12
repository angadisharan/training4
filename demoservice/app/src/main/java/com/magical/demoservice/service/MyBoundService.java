package com.magical.demoservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sharanangadi on 12/06/17.
 */

public class MyBoundService extends Service {
    private static final String TAG = "MYAPP:MyBoundService";


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);
    }


    public void pintNumbers() {
        for (int i = 0; i < 100; i++) {
            Log.d(TAG, "inside service " + i);
            Toast.makeText(this, "inside service " + i, Toast.LENGTH_SHORT).show();
        }
    }
    MyBinder myBinder = new MyBinder();

    public class MyBinder extends Binder {
        public MyBoundService getService() {
            return MyBoundService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
}
