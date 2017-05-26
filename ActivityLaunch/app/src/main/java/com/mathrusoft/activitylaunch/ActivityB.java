package com.mathrusoft.activitylaunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by sharanangadi on 26/05/17.
 */

public class ActivityB extends AppCompatActivity {

    TextView mTextViewName;
    TextView mTextViewAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_b);


        mTextViewAge = (TextView) findViewById(R.id.age);
        mTextViewName = (TextView) findViewById(R.id.name);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("data_name");
        int age = intent.getExtras().getInt("data_age");

        Log.d("MYAPP", " age " + age);


        mTextViewAge.setText(age + "");
        mTextViewName.setText(name);


    }
}
