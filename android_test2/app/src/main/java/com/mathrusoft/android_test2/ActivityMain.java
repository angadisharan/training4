package com.mathrusoft.android_test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity {

    Button mButtonLaunchRelativeActivity;
    Button mButtonLaunchFrameActivity;
    Button mButtonLaunchScrollActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButtonLaunchRelativeActivity = (Button) findViewById(R.id.button_relative_activity);
        mButtonLaunchFrameActivity = (Button) findViewById(R.id.button_framelayout_activity);
        mButtonLaunchScrollActivity = (Button) findViewById(R.id.button_scroll_activity);


        mButtonLaunchRelativeActivity.setOnClickListener(mOnClickListener);
        mButtonLaunchFrameActivity.setOnClickListener(mOnClickListener);
        mButtonLaunchScrollActivity.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.button_relative_activity:
                    Intent intent = new Intent(ActivityMain.this, ActivityDemoRelativeLayout.class);
                    startActivity(intent);
                    break;
                case R.id.button_framelayout_activity:
                    intent = new Intent(ActivityMain.this, ActivityDemoFrameLayout.class);
                    startActivity(intent);
                    break;
                case R.id.button_scroll_activity:
                    intent = new Intent(ActivityMain.this, ActivityDemoScroolView.class);
                    startActivity(intent);
                    break;
            }


        }
    };



}
