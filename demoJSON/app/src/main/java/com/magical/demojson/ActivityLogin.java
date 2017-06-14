package com.magical.demojson;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by sharanangadi on 14/06/17.
 */

public class ActivityLogin extends AppCompatActivity {

    private final String TAG = "MYAPP";

    private Context mContext;

    private EditText mEditTextUserName;
    private EditText mEditTextPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this.getApplication();

        mEditTextUserName = (EditText) findViewById(R.id.user_name);
        mEditTextPassword = (EditText) findViewById(R.id.password);

        findViewById(R.id.submit).setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            hitDummyURL();

        }
    };


    private void hitDummyURL() {
        RequestQueue requestQueue = Volley.newRequestQueue(ActivityLogin.this);
        Response.Listener<String> successListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(mContext, response, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "inside onResponse " + response);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "inside onErrorResponse" + error.getMessage());
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "http://www.google.com", successListener, errorListener);

        requestQueue.add(stringRequest);

    }

}
