package com.mathrusoft.mimiclogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class ActivityLogin extends AppCompatActivity {

    EditText mEditTextUserName;
    EditText mEditTextUserPassword;
    Button mButtonSubmit;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        SharedPreferences sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("user_name", "").trim();
        String password = sharedPreferences.getString("password", "").trim();


        Log.d("MYAPP", "userName : " + userName);
        Log.d("MYAPP", "password : " + password);

        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password) && userName.equals(password)) {
            Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
            startActivity(intent);
            ActivityLogin.this.finish();
            return;
        }


        mContext = this.getApplicationContext();

        mEditTextUserName = (EditText) findViewById(R.id.user_name);
        mEditTextUserPassword = (EditText) findViewById(R.id.password);
        mButtonSubmit = (Button) findViewById(R.id.submit);

        mButtonSubmit.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (TextUtils.isEmpty(mEditTextUserName.getText().toString())) {
                mEditTextUserName.setError("User name empty");
                mEditTextUserName.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(mEditTextUserPassword.getText().toString())) {
                mEditTextUserPassword.setError("Password empty");
                mEditTextUserPassword.requestFocus();
                return;
            }

            String userName = mEditTextUserName.getText().toString();
            String password = mEditTextUserPassword.getText().toString();

            if (userName.equals(password)) {
                Toast.makeText(mContext, "Login Success", Toast.LENGTH_SHORT).show();

                SharedPreferences sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_name", userName.trim());
                editor.putString("password", password.trim());
                editor.commit();

                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);
                ActivityLogin.this.finish();
            } else {
                Toast.makeText(mContext, "Login Failed", Toast.LENGTH_SHORT).show();
            }

        }
    };

}

