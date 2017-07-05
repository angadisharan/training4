package com.mathrusoft.demodatabase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by sharanangadi on 05/07/17.
 */

public class ActivityBoradcastDemo extends AppCompatActivity {

    MyInternetChangeReceiver myInternetChangeReceiver = new MyInternetChangeReceiver();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_broadcast);

        findViewById(R.id.send_broadcast).setOnClickListener(mOnClickListener);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.mathrusoft.demodatabase.MYCUSOSTOM_RECEIVER");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myInternetChangeReceiver, intentFilter);



    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myInternetChangeReceiver);
    }

    class MyInternetChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("MYAPP", " inside dynamica receiver ");
        }
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent();
            intent.setAction("com.mathrusoft.demodatabase.MYCUSOSTOM_RECEIVER");
            sendBroadcast(intent);


        }
    };

}
