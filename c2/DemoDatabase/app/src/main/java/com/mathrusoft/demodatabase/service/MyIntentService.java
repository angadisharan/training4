package com.mathrusoft.demodatabase.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by sharanangadi on 08/07/17.
 */

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("MYAPP", "inside onHandleIntent MyIntentService");

    }

    @Override
    public void onDestroy() {

        Log.d("MYAPP", "inside onDesotoy MyIntentService");

        super.onDestroy();
    }
}

