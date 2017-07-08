package com.mathrusoft.demodatabase.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by sharanangadi on 08/07/17.
 */

public class MyBoundService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_NOT_STICKY;
    }

    MyBoundService myBoundService = this;

    public class MyBinder extends Binder {

        public MyBoundService getMyService() {
            return myBoundService;
        }
    }

    MyBinder myBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public int getRandomNumber() {
        return new Random().nextInt(100);
    }
}
