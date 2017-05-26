package com.mathrusoft.activitylaunch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityA extends AppCompatActivity {

    Button mButtonLaunchB;
    Button mButtonLaunchC;
    Button mButtonLaunchDailogue;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_activity);

        mContext = this.getApplicationContext();

        mButtonLaunchB = (Button) findViewById(R.id.button_launch_b);
        mButtonLaunchC = (Button) findViewById(R.id.button_launch_c);
        mButtonLaunchDailogue = (Button) findViewById(R.id.button_launch_dailogue);


        mButtonLaunchB.setOnClickListener(mOnClickListener);
        mButtonLaunchC.setOnClickListener(mOnClickListener);
        mButtonLaunchDailogue.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_launch_b:
                    Intent intent = new Intent(ActivityA.this, ActivityB.class);

                    intent.putExtra("data_name", "Anil");
                    intent.putExtra("data_age", 21);

                    ActivityA.this.startActivity(intent);
                    break;
                case R.id.button_launch_c:
                    Intent intentC = new Intent(ActivityA.this, ActivityC.class);
                    ActivityA.this.startActivityForResult(intentC, 12);
                    break;
                case R.id.button_launch_dailogue:
                    launchDailogue();
                    break;
            }
        }
    };

    private void launchDailogue() {

        new AlertDialog.Builder(ActivityA.this)
                .setTitle("Hello Title")
                .setMessage("Hello description")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "OK clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Canvel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12) {
            String name = "";
            if (data != null) {
                name = data.getExtras().getString(ActivityC.KEY_NAME);
            }
            Toast.makeText(mContext, " Data from Activity C " + name, Toast.LENGTH_SHORT).show();
        }

    }
}
