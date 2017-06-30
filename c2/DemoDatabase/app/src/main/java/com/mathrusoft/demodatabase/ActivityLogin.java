package com.mathrusoft.demodatabase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharanangadi on 30/06/17.
 */

public class ActivityLogin extends AppCompatActivity {


    Context mContext;


    EditText mEditTextUserId;
    EditText mEditTextPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mEditTextUserId = (EditText) findViewById(R.id.user_name);
        mEditTextPassword = (EditText) findViewById(R.id.password);

        mContext = this.getApplicationContext();

        findViewById(R.id.submit).setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            performLogin();
        }
    };


    private void performLogin() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        Response.Listener<String> successListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(mContext, " response " + response, Toast.LENGTH_SHORT).show();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MYAPP", "VOllye error", error);
                Toast.makeText(mContext, " Error occured", Toast.LENGTH_SHORT).show();

            }
        };


        String url = "http://www.mathrusoft.com:5005/login";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("MYAPP", "response " + response);

                Toast.makeText(mContext, " response " + response, Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("MYAPP", "VOLLEY error", error);

                Log.d("MYAPP", "error " + error.getMessage());
                Toast.makeText(mContext, " Error occured", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> headers = new HashMap<>();

                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {

                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("user_id", mEditTextUserId.getText().toString());
                    jsonBody.put("password", mEditTextPassword.getText().toString());
                } catch (JSONException e) {
                    Log.e("MYAPP", "Error ", e);
                }

                return jsonBody.toString().getBytes();
            }
        };

        requestQueue.add(stringRequest);

    }


}
