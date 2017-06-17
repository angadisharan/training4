package com.magical.demojson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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


        SharedPreferences sharedPreferences = getSharedPreferences("my_pref", MODE_PRIVATE);

        if (!TextUtils.isEmpty(sharedPreferences.getString("user_token", ""))) {
            Intent intent = new Intent(this, ActivityMain.class);
            startActivity(intent);
            ActivityLogin.this.finish();
            return;
        }

        mContext = this.getApplication();

        mEditTextUserName = (EditText) findViewById(R.id.user_name);
        mEditTextPassword = (EditText) findViewById(R.id.password);

        findViewById(R.id.submit).setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            performLogin();
        }
    };

    private void performLogin() {
        if (TextUtils.isEmpty(mEditTextUserName.getText().toString())) {
            mEditTextUserName.setError("Username empty");
            mEditTextUserName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(mEditTextPassword.getText().toString())) {
            mEditTextPassword.setError("Password empty");
            mEditTextPassword.requestFocus();
            return;
        }

        final JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("user_id", mEditTextUserName.getText().toString());
            jsonBody.put("password", mEditTextPassword.getText().toString());
        } catch (Exception e) {
            Log.e(TAG, "Exception ", e);
        }

        RequestQueue requestQueue = Volley.newRequestQueue(ActivityLogin.this);
        Response.Listener<String> successListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(mContext, response, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "inside onResponse " + response);

                try {
                    JSONObject jsonResponse = new JSONObject(response);

                    SharedPreferences sharedPreferences = getSharedPreferences("my_pref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("user_token", jsonResponse.getString("token"));
                    editor.commit();

//                    AlertDialog alertDialog = new AlertDialog.Builder(ActivityLogin.this)
//                            .setMessage(jsonResponse.getString("message"))
//                            .setTitle(jsonResponse.getString("title"))
//                            .show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "inside onErrorResponse" + error.getMessage());
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://www.mathrusoft.com:5005/login", successListener, errorListener) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return jsonBody.toString().getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };

        requestQueue.add(stringRequest);
    }


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
