package com.mathrusoft.demodatabase;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Contacts;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mathrusoft.demodatabase.service.MyBoundService;
import com.mathrusoft.demodatabase.service.MyIntentService;
import com.mathrusoft.demodatabase.service.MyService;

/**
 * Created by sharanangadi on 08/07/17.
 */

public class ActivityDemoService extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_service);

        mContext = this.getApplicationContext();

        findViewById(R.id.start_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.stop_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.get_random_number_from_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.start_intent_service).setOnClickListener(mOnClickListener);

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.start_service:
                    Intent intent = new Intent(ActivityDemoService.this, MyService.class);
                    startService(intent);
                    break;
                case R.id.start_intent_service:
                    intent = new Intent(ActivityDemoService.this, MyIntentService.class);
                    startService(intent);
                    break;
                case R.id.stop_service:
                    intent = new Intent(ActivityDemoService.this, MyService.class);
                    stopService(intent);
                    break;
                case R.id.get_random_number_from_service:

                    if (myBoundService == null) {
                        Toast.makeText(mContext, "Service is null", Toast.LENGTH_SHORT).show();
                    } else {
                        int randomNumber = myBoundService.getRandomNumber();
                        Toast.makeText(mContext, "Random number from service is " + randomNumber, Toast.LENGTH_SHORT).show();
                    }

                    break;
            }
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(ActivityDemoService.this, MyBoundService.class);

        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
    }

    Context mContext;

    MyBoundService myBoundService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("MYAPP", "Inside onServiceCOnnected");
            myBoundService = ((MyBoundService.MyBinder) iBinder).getMyService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("MYAPP", "Inside onServiceDisconnected");
            myBoundService = null;
        }
    };

}

