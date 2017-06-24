package com.mathrusoft.testone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by sharanangadi on 22/06/17.
 */

public class ActivityMain extends Activity {

    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button_launch_activity_b);
        mButton.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(ActivityMain.this, ActivityB.class);
            startActivity(intent);

            Log.d("MYAPP", "Insideonclick");
        }
    };


}
