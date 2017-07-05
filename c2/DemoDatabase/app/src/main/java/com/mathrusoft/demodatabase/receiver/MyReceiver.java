package com.mathrusoft.demodatabase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sharanangadi on 05/07/17.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("MYAPP", " inside on receive " + intent.getAction());

    }
}
