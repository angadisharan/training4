package com.mathrusoft.demodatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sharanangadi on 05/07/17.
 */

public class ActivityFront extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_front);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();


        intent.putExtra("MYDATA", 123123);
        setResult(RESULT_OK, intent);

        finish();






    }
}
