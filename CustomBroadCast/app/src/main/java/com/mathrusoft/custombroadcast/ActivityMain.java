package com.mathrusoft.custombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.send_broadcast).setOnClickListener(mOnClickListener);

        IntentFilter intentFilter = new IntentFilter("com.mathrusoft.custombroadcast.MY_CUSTOM_RECEIVER");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent();
            intent.setAction("com.mathrusoft.custombroadcast.MY_CUSTOM_RECEIVER");

            sendBroadcast(intent);

        }
    };


    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(ActivityMain.this, "Inside dynamic registered reciver ", Toast.LENGTH_LONG).show();
        }
    };


}
