package com.magical.demoservice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.magical.demoservice.service.MyBoundService;
import com.magical.demoservice.service.MyIntentService;
import com.magical.demoservice.service.ServiceDemo;

import static com.magical.demoservice.R.id.start_intent_service;
import static com.magical.demoservice.R.id.stop_intent_service;

public class ActivityMain extends AppCompatActivity {

    Context mContext;

    Button mButtonStartService;
    Button mButtonStopService;

    private void showNotifictaion() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, ActivityMain.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ActivityMain.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(12, mBuilder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();
        //Just to show notification example
//        showNotifictaion();

        mButtonStartService = (Button) findViewById(R.id.start_intent_service);
        mButtonStopService = (Button) findViewById(R.id.start_service);

        mButtonStartService.setOnClickListener(mOnClickListener);
        mButtonStopService.setOnClickListener(mOnClickListener);


        findViewById(start_intent_service).setOnClickListener(mOnClickListener);
        findViewById(stop_intent_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.print_numbers_form_service).setOnClickListener(mOnClickListener);

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start_service:
                    Intent service = new Intent(ActivityMain.this, ServiceDemo.class);
                    startService(service);
                    break;
                case R.id.stop_service:
                    service = new Intent(ActivityMain.this, ServiceDemo.class);
                    stopService(service);
                    break;
                case R.id.start_intent_service:
                    service = new Intent(ActivityMain.this, MyIntentService.class);
                    startService(service);
                    break;
                case R.id.stop_intent_service:
                    service = new Intent(ActivityMain.this, MyIntentService.class);
                    stopService(service);
                    break;

                case R.id.print_numbers_form_service:
                    if (myBoundService != null) {
                        myBoundService.pintNumbers();
                    }
                    break;
            }
        }
    };


    MyBoundService myBoundService;
    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Toast.makeText(mContext, "Service Connected", Toast.LENGTH_SHORT).show();
            myBoundService = ((MyBoundService.MyBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myBoundService = null;
            Toast.makeText(mContext, "Service dis Connected", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mServiceConnection);
    }
}
