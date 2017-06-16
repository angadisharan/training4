package com.mathrusoft.firstandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sharanangadi on 16/06/17.
 */

public class ActivityMain extends Activity {

    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button_greeting);
        mButton.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(ActivityMain.this, "Welcome to Mathrusoft", Toast.LENGTH_SHORT).show();
        }
    };
}
