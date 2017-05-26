package com.mathrusoft.activitylaunch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by sharanangadi on 26/05/17.
 */

public class ActivityC extends AppCompatActivity {


    public static String KEY_NAME = "data_name_from_c";
    Button mButtonKillMe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        mButtonKillMe = (Button) findViewById(R.id.kill_me);
        mButtonKillMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(KEY_NAME, "Mass from Activity C");
                ActivityC.this.setResult(Activity.RESULT_OK, intent);
                ActivityC.this.finish();
            }
        });
    }




}
