package com.mathrusoft.demodatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by sharanangadi on 05/07/17.
 */

public class ActivityBaseForResult extends AppCompatActivity {


    private final int MY_FRONT_REQUEST_CODE = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_for_result);

        findViewById(R.id.start_front_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActivityBaseForResult.this, ActivityFront.class);
                startActivityForResult(intent, MY_FRONT_REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("MYAPP", "inside onActivity result " + requestCode + " resultCode " + resultCode);

        if (resultCode == Activity.RESULT_OK) {

            if (data != null) {
                Log.d("MYAPP", " From front activity : " + data.getIntExtra("MYDATA", 0));
            }

        } else if (resultCode == Activity.RESULT_CANCELED) {

        }

    }


}
