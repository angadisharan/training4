package com.mathrusoft.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityMain extends AppCompatActivity {

    private static final String TAG = "MYAPP:ActivityA";
    TextView mTextViewLaunchB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewLaunchB = (TextView) findViewById(R.id.launch_activity_b);
        mTextViewLaunchB.setOnClickListener(mOnClickListener);
        Log.d(TAG, "inside onCreate");
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ActivityMain.this, ActivityB.class);
            ActivityMain.this.startActivity(intent);
        }
    };

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
