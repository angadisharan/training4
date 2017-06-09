package com.magical.demoservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.magical.demoservice.service.ServiceDemo;

import static com.magical.demoservice.R.id.start_service;
import static com.magical.demoservice.R.id.stop_service;

public class ActivityMain extends AppCompatActivity {

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

        //Just to show notification example
        showNotifictaion();

        mButtonStartService = (Button) findViewById(start_service);
        mButtonStopService = (Button) findViewById(stop_service);

        mButtonStartService.setOnClickListener(mOnClickListener);
        mButtonStopService.setOnClickListener(mOnClickListener);

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
            }
        }
    };
}
