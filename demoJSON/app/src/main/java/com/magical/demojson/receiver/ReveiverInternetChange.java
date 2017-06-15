package com.magical.demojson.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by sharanangadi on 15/06/17.
 */

public class ReveiverInternetChange extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            Log.d("MYAPP", "Network Available Flag No 1");
        } else {
            Log.d("MYAPP", "Network not Available Flag No 1");
        }

    }
}
