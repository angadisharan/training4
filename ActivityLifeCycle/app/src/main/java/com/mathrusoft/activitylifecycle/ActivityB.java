package com.mathrusoft.activitylifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sharanangadi on 15/05/17.
 */

public class ActivityB extends AppCompatActivity {

    private static final String TAG = "MYAPP:ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d(TAG, "inside onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "inside onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "inside onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "inside onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "inside onPause");
    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "inside onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside onDestroy");
    }
}
