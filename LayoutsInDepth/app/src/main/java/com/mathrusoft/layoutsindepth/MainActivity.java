package com.mathrusoft.layoutsindepth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mButtonOK;
    Button mButtonCancel;

    EditText mEditTextUserName;
    EditText mEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonOK = (Button) findViewById(R.id.button_ok);
        mButtonCancel = (Button) findViewById(R.id.button_cancel);

        mEditTextUserName = (EditText) findViewById(R.id.user_name);
        mEditTextPassword = (EditText) findViewById(R.id.password);


        mButtonOK.setOnClickListener(mOnClickListener);
        mButtonCancel.setOnClickListener(mOnCancelClickListener);

    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String name = mEditTextUserName.getText().toString();
            String password = mEditTextPassword.getText().toString();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                Toast.makeText(MainActivity.this, "User id or password is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (name.equals(password)) {
                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    };

    View.OnClickListener mOnCancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivity.this.finish();
            Toast.makeText(MainActivity.this, "Thank you", Toast.LENGTH_SHORT).show();
        }
    };

}
